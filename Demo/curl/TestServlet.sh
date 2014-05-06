echo ">>>>> TEST GET METHOD OF TESTSERVLET <<<<<"
content=$(curl -v localhost:8080/TestServlet)
if [[ $content =~ .*'Method GET work'.* ]]
then
	echo "[MESSAGE TEST] GET IS OK"
	echo ">>>>> TEST POST METHOD OF TESTSERVLET <<<<<"
	contentPost=$(curl -X POST -H "Accept: application/json" -H "Content-type: application/json" -d '{"name":"Wiperdog"}' http://localhost:8080/TestServlet -v)
	if [[ $contentPost =~ .*'Wiperdog'.* ]]
	then
		echo "[MESSAGE TEST] POST IS OK"
	else
		echo "[MESSAGE TEST] POST IS FAILURE"
	fi
else
	echo "[MESSAGE TEST] GET IS FAILURE, SO CANNOT TEST POST METHOD"
fi
