set ns [new Simulator]
set nf [open out.nam w]
$ns namtrace-all $nf
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



set lan [$ns newLan "$n0 $n1 $n2" 2Mb 100ms dropTail]



set udp [new Agent/UDP]
$ns attach-agent $n0 $udp

set null [new Agent/Null]
$ns attach-agent $n1 $null

$ns connect $udp $null

set cbr [new Application/Traffic/CBR]
$cbr set packetsize_ 100
$cbr set interval_ 0.05
$cbr attach-agent $udp

$ns at 0.5 "$cbr start"
$ns at 4.5 "$cbr stop"

$ns at 5.0 "finish"

$ns run
