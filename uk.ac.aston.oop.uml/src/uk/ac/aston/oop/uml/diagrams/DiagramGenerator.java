package uk.ac.aston.oop.uml.diagrams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import net.sourceforge.plantuml.BlockUml;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceFileReader;
import net.sourceforge.plantuml.core.Diagram;
import net.sourceforge.plantuml.error.PSystemError;

public class DiagramGenerator {

    private final Path targetFolder;

    public DiagramGenerator(Path targetFolder) {
        this.targetFolder = targetFolder;
    }

    public void processFolder(Path sourceFolder) throws IOException {
        clearTargetFolder();

        try (Stream<Path> paths = Files.walk(sourceFolder)) {
            paths.filter(Files::isRegularFile)
                 .filter(path -> path.toString().endsWith(".txt"))
                 .sorted(Comparator.comparing(Path::getFileName))
                 .forEach(this::processFile);
        }
    }

    private void clearTargetFolder() throws IOException {
        try (Stream<Path> paths = Files.walk(targetFolder)) {
            paths.sorted(Comparator.reverseOrder())
                 .map(Path::toFile)
                 .forEach(File::delete);
        }
    }

    private void processFile(Path sourceFile) {
        System.out.println("==> PROCESSING " + sourceFile.getFileName());
        try {
            for (FileFormat format : new FileFormat[]{FileFormat.XMI_STAR, FileFormat.PNG}) {
                generate(sourceFile, format);
            }
            System.out.println("  * OK");
        } catch (IOException | InvalidDiagramException e) {
            System.err.println("Failed to process file " + sourceFile + ": " + e.getMessage());
        }
    }

    private void generate(Path sourceFile, FileFormat format) throws IOException, InvalidDiagramException {
        SourceFileReader reader = new SourceFileReader(sourceFile.toFile(), targetFolder.toFile());
        validate(reader);
        reader.setFileFormatOption(new FileFormatOption(format));
        reader.getGeneratedImages();
    }

    private void validate(SourceFileReader reader) throws InvalidDiagramException {
        for (BlockUml block : reader.getBlocks()) {
            Diagram diagram = block.getDiagram();
            if (diagram instanceof PSystemError) {
                throw new InvalidDiagramException(constructErrorMessage((PSystemError) diagram));
            }
        }
    }

    private String constructErrorMessage(PSystemError error) {
        StringBuilder sb = new StringBuilder();
        for (net.sourceforge.plantuml.ErrorUml err : error.getErrorsUml()) {
            sb.append(String.format("Error at %s:%d: %s\n", err.getLineLocation(), err.getPosition(), err.getError()));
        }
        return sb.toString();
    }

    public static class InvalidDiagramException extends Exception {
        public InvalidDiagramException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) throws IOException {
        Path targetFolder = new File("diagrams").toPath().toAbsolutePath();
        Files.createDirectories(targetFolder);

        new DiagramGenerator(targetFolder).processFolder(new File("plantuml").toPath());
    }
}
\
