#!/bin/bash

fold="$1"
user="$2"
rsync -avz "$fold" "$user"