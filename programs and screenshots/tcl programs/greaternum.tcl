set a 10
set b 15
set c 6

if {$a>$b} {
if {$a>$c} {
puts "$a is greater"} }
if {$b>$a} {
if {$b>$c} {
puts "$b is greater"} }
if {$c>$a} {
if {$c>$b}
{
puts "$c is greater"} }
