# Define setting options
set val(chan)           Channel/WirelessChannel    ;# channel type
set val(prop)           Propagation/TwoRayGround   ;# radio-propagation model
set val(netif)          Phy/WirelessPhy            ;# network interface type
set val(mac)            Mac/802_11                 ;# MAC type
set val(ifq)            Queue/DropTail/PriQueue    ;# interface queue type
set val(ll)             LL                         ;# link layer type
set val(ant)            Antenna/OmniAntenna        ;# antenna model
set val(ifqlen)         50                         ;# max packet in ifq
set val(nn)             8                          ;# number of mobilenodes
set val(rp)             AODV                       ;# routing protocol
set val(x)              500                        ;# X dimension of topography
set val(y)              400                        ;# Y dimension of topography  
set val(stop)           10                   ;# time of simulation end

set ns              [new Simulator]

#Creating nam and trace file:
set tracefd       [open wireless2.tr w]
set namtrace      [open wireless2.nam w]   

$ns trace-all $tracefd
$ns namtrace-all-wireless $namtrace $val(x) $val(y)

# set up topography object
set topo       [new Topography]

$topo load_flatgrid $val(x) $val(y)

set god_ [create-god $val(nn)]

# configure the nodes
        $ns node-config -adhocRouting $val(rp) \
                   -llType $val(ll) \
                   -macType $val(mac) \
                   -ifqType $val(ifq) \
                   -ifqLen $val(ifqlen) \
                   -antType $val(ant) \
                   -propType $val(prop) \
                   -phyType $val(netif) \
                   -channelType $val(chan) \
                   -topoInstance $topo \
                   -agentTrace ON \
                   -routerTrace ON \
                   -macTrace OFF \
                   -movementTrace ON
                   
## Creating node objects..          
for {set i 0} {$i < 3 } { incr i } {
            set node_($i) [$ns node]      
      }
      for {set i 0} {$i < 3  } {incr i } {
            $node_($i) color blue
            $ns at 0.0 "$node_($i) color blue"
      }
for {set i 3} {$i < 6 } { incr i } {
            set node_($i) [$ns node]      
      }
      for {set i 3} {$i < 5  } {incr i } {
            $node_($i) color cyan
            $ns at 0.0 "$node_($i) color cyan"
      }
for {set i 5} {$i < 8 } { incr i } {
            set node_($i) [$ns node]      
      }
      for {set i 5} {$i < 8  } {incr i } {
            $node_($i) color red
            $ns at 0.0 "$node_($i) color red"
      }

## Provide initial location of mobilenodes..
            for {set i 0} {$i < $val(nn) } { incr i } {
                  set xx [expr rand()*500]
                  set yy [expr rand()*400]
                  $node_($i) set X_ $xx
                  $node_($i) set Y_ $yy
                  
            }

# Define node initial position in nam
for {set i 0} {$i < $val(nn)} { incr i } {
# 30 defines the node size for nam
$ns initial_node_pos $node_($i) 30
}

# Telling nodes when the simulation ends
for {set i 0} {$i < $val(nn) } { incr i } {
    $ns at $val(stop) "$node_($i) reset";
}

# dynamic destination setting procedure..
$ns at 0.0 "destination"
proc destination {} {
      global ns val node_ 
      set time 1.0
      set now [$ns now]
      for {set i 0} {$i<$val(nn)} {incr i} {
            set xx [expr rand()*500]
            set yy [expr rand()*400]
            $ns at $now "$node_($i) setdest $xx $yy 10.0"
      }
      $ns at [expr $now+$time] "destination"
}

#stop procedure..
$ns at $val(stop) "stop"
proc stop {} {
    global ns tracefd namtrace
    $ns flush-trace
    close $tracefd
    close $namtrace
exec nam wireless2.nam &
}

$ns run
