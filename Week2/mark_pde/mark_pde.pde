 // 80 and above is A, 60 and above is B
// 40 and above is C, everything else is F
// first generate a random mark
 float mark = random(0, 100);

 
 if (mark>=80 ) {
println("Mark " + mark + " Grade A.");
} 
else if (mark>=80) {
println("Mark " + mark + " Grade B.");
} 
else if ( mark>=40) {
println("Mark " + mark + " Grade C.");
}
else {
println("Mark " + mark + " Grade F.");
}
