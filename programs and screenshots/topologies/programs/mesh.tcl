set ns [new Simulator]
set nf [open out.nam w]
$ns namtrace-all $nf
$ns color 1 Blue
$ns color 2 Red

proc finish {} {
    global ns nf
    $ns flush-trace
    close $nf
    exec nam out.nam &
    exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

$ns duplex-link $n0 $n1 1Mb 2ms DropTail
$ns duplex-link $n0 $n2 1Mb 2ms DropTail
$ns duplex-link $n0 $n3 1Mb 2ms DropTail

$ns duplex-link $n1 $n2 1Mb 2ms DropTail
$ns duplex-link $n1 $n3 1Mb 2ms DropTail

$ns duplex-link $n2 $n3 1Mb 2ms DropTail

$ns duplex-link $n3 $n1 1Mb 2ms DropTail

$ns duplex-link-op $n1 $n0 orient right-down
$ns duplex-link-op $n1 $n2 orient right-up
$ns duplex-link-op $n2 $n3 orient right-down
$ns duplex-link-op $n3 $n2 orient right-down

set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0
set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 100
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0
$udp0 set class_ 1
set null0 [new Agent/Null] 
$ns attach-agent $n1 $null0

set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1
set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 100
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1
$udp1 set class_ 2
set null1 [new Agent/Null] 
$ns attach-agent $n2 $null1 

set udp2 [new Agent/UDP]
$ns attach-agent $n2 $udp2
set cbr2 [new Application/Traffic/CBR]
$cbr2 set packetSize_ 100
$cbr2 set interval_ 0.005
$cbr2 attach-agent $udp2
$udp2 set class_ 3
set null2 [new Agent/Null] 
$ns attach-agent $n3 $null2

set udp3 [new Agent/UDP]
$ns attach-agent $n3 $udp3
set cbr3 [new Application/Traffic/CBR]
$cbr3 set packetSize_ 100
$cbr3 set interval_ 0.005
$cbr3 attach-agent $udp3
$udp3 set class_ 3
set null3 [new Agent/Null] 
$ns attach-agent $n0 $null3


$ns connect $udp0 $null0 
$ns connect $udp1 $null1
$ns connect $udp2 $null2
$ns connect $udp3 $null3

$ns at 0.5 "$cbr0 start"
$ns at 1.5 "$cbr1 start"
$ns at 3.0 "$cbr2 start"
$ns at 4.5 "$cbr3 start"
$ns at 1.5 "$cbr0 stop"
$ns at 3.0 "$cbr1 stop"
$ns at 4.5 "$cbr2 stop"
$ns at 5.0 "$cbr3 stop"
$ns at 5.0 "finish"

$ns run

