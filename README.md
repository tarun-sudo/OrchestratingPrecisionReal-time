FraudGuard DecisioSync is an innovative and robust real-time fraud detection system designed to deliver unparalleled
precision and responsiveness. In the realm of cybersecurity, where threats evolve dynamically, our project stands as a
sentinel, orchestrating decisive synchronization (DecisioSync) to safeguard against fraudulent activities.

Key Features:

Real-time Precision: Leverage the power of Apache Kafka and Spring Boot to ensure real-time processing, allowing for
instant detection and response to fraudulent transactions.

Dynamic Collaboration: Integrate resilient synchronization mechanisms to enable seamless collaboration among remote
teams, enhancing the adaptability of the system to evolving fraud patterns.

Quantum-like Decision Making: Embrace a quantum-inspired approach to decision-making, providing an intelligent and
adaptive defense against sophisticated fraud attempts.

Scalable Architecture: Built on a scalable architecture, FraudGuard DecisioSync accommodates growing datasets and
evolving security requirements, ensuring longevity and effectiveness.

Decisive Orchestration: The system orchestrates decisive actions, from identifying anomalies to triggering alerts and
responses, ensuring a proactive stance against potential threats.

### To run zookeeper

1. First, download ZooKeeper from the Apache website:

2. Go to the ZooKeeper releases page. Download the latest stable version (e.g., zookeeper-3.8.2.tar.gz).

3. Extract the Downloaded Archive After downloading, extract the archive to a preferred location:

bash Copy code tar -xzf zookeeper-3.8.2.tar.gz cd zookeeper-3.8.2

1. Configure ZooKeeper ZooKeeper requires a configuration file to run. You can create this file in the conf directory.

Go to the conf directory:

1. bash Copy code cd conf Create a configuration file named zoo.cfg:

2. bash Copy code touch zoo.cfg Open the zoo.cfg file in a text editor and add the following basic configuration:

##properties

1. The number of ticks that the initial
2. tickTime=2000 (The number of milliseconds of each tick)
###synchronization phase can take

1. initLimit=10
2. The number of ticks that can pass between

###sending a request and getting an acknowledgment

syncLimit=5

###The directory where the snapshot is stored.

dataDir=/tmp/zookeeper

###The port at which the clients will connect

1. clientPort=2181 This is a basic configuration for a standalone ZooKeeper instance.

2. Start ZooKeeper After configuring ZooKeeper, you can start it up.

Go back to the root directory of your extracted ZooKeeper:

1. bash  cd .. Start ZooKeeper by running:

2. bash Copy code bin/zkServer.sh start This will start ZooKeeper with the configuration provided in conf/zoo.cfg.

###To check the status of your ZooKeeper instance, use:

bash Copy code bin/zkServer.sh status

1. Stop ZooKeeper To stop ZooKeeper, use the following command:

2. bash Copy code bin/zkServer.sh stop

3. Connecting to ZooKeeper To interact with your ZooKeeper instance, you can use the ZooKeeper CLI:

4. bash Copy code bin/zkCli.sh -server localhost:2181 This command opens a ZooKeeper CLI connected to your local ZooKeeper
instance.

### ZooKeeper in a Kafka Cluster

If you're setting up ZooKeeper to work with a Kafka cluster, Kafka will automatically connect to ZooKeeper using the
zookeeper.connect property in Kafka's configuration. You should have ZooKeeper running before starting Kafka.

### Running ZooKeeper in Docker (Alternative)

Alternatively, you can run ZooKeeper in Docker, which is simpler if you have Docker installed:

bash Copy code

### To run on Docker

docker run -d --name zookeeper -p 2181:2181 zookeeper This command pulls the latest ZooKeeper image from Docker Hub and
runs it in a container.