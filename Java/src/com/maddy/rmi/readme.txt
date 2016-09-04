javac -d . *.java
# create stub
rmic com.maddy.rmi.RemoteCalculator
# start server
java com.maddy.rmi.RmiServer
# start client
java com.maddy.rmi.RmiClient
