#Create a simulator object
set ns [new Simulator]


#Open the nam trace file

set nf [open out.nam w]

$ns namtrace-all $nf


#Define a 'finish' procedure

proc finish {} {

        global ns nf
        
$ns flush-trace
	
#Close the trace file
        
close $nf
	
#Execute nam on the trace file
        
exec nam out.nam &

        exit 0
}



# Insert your own code for topology creation
$ns color 1 Blue
$ns color 2 Red
$ns color 3 Red
$ns color 4 Red
$ns color 5 Red
$ns color 6 Red

for {set i 0} {$i < 7} {incr i} {
set n$i  [$ns node]
}

#star1
$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n2 $n1 1Mb 10ms DropTail
$ns duplex-link $n3 $n1 1Mb 10ms DropTail
$ns duplex-link $n4 $n1 1Mb 10ms DropTail



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
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1
$udp1 set class_ 2
set null1 [new Agent/Null] 
$ns attach-agent $n2 $null1 

set udp2 [new Agent/UDP]
$ns attach-agent $n2 $udp2
set cbr2 [new Application/Traffic/CBR]
$cbr2 set packetSize_ 500
$cbr2 set interval_ 0.005
$cbr2 attach-agent $udp2
$udp2 set class_ 3
set null2 [new Agent/Null] 
$ns attach-agent $n1 $null2

set udp3 [new Agent/UDP]
$ns attach-agent $n1 $udp3
set cbr3 [new Application/Traffic/CBR]
$cbr3 set packetSize_ 500
$cbr3 set interval_ 0.005
$cbr3 attach-agent $udp3
$udp3 set class_ 3
set null3 [new Agent/Null] 
$ns attach-agent $n3 $null3

$ns connect $udp0 $null0 
$ns connect $udp1 $null1
$ns connect $udp2 $null2
$ns connect $udp3 $null3
$ns at 0.5 "$cbr0 start" 
 $ns at 1.0 "$cbr1 start"
$ns at 3.0 "$cbr2 start"
$ns at 4.0 "$cbr3 start"
$ns at 2.5 "$cbr0 stop"
$ns at 3.0 "$cbr1 stop"
$ns at 4.0 "$cbr2 stop"
$ns at 4.5 "$cbr3 stop"

#bus
set lan [$ns newLan "$n1 $n5  " 2Mb 100ms dropTail]

set udp [new Agent/UDP]
$ns attach-agent $n1 $udp

set null [new Agent/Null]
$ns attach-agent $n5 $null

$ns connect $udp $null

set cbr [new Application/Traffic/CBR]
$cbr set packetsize_ 100
$cbr set interval_ 0.05
$cbr attach-agent $udp

$ns at 0.5 "$cbr start"
$ns at 4.5 "$cbr stop"




# and agent definitions, etc. here



#Call the finish procedure after 5 seconds simulation time

$ns at 5.0 "finish"


#Run the simulation

$ns run

