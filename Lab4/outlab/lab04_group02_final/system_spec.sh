#!/bin/bash
cpu_speed=$( fgrep "cpu MHz" /proc/cpuinfo | awk 'FNR == 1 {print}')
address_sizes=$(fgrep "address sizes" /proc/cpuinfo | awk 'FNR == 1 {print}')
echo $cpu_speed
echo $address_sizes
exit
