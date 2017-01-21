#!/bin/bash
usrn="$1"
serv="$2"
if [[ -z "$usrn" ]]; then
	echo "Error"
	exit 1
fi
if [[ -z "$serv" ]]; then
	echo "Error"
	exit 2
fi
# cat ~/.ssh/id_rsa.pub | ssh user@host 'cat > ~/.ssh/authorized_keys'
cat ~/.ssh/id_rsa.pub | ssh "$usrn"@"$serv" 'cat > ~/.ssh/authorized_keys'