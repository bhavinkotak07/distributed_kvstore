### Distributed Key Value store
A key-value store, or key-value database is a simple database that uses an associative array (think of a map or dictionary) as the fundamental data model where each key is associated with one and only one value in a collection. This relationship is referred to as a key-value pair.

In each key-value pair the key is represented by an arbitrary string such as a filename, URI or hash. The value can be any kind of data like an image, user preference file or document. The value is stored as a blob requiring no upfront data modeling or schema definition.
The amount of data that can be stored on a single is limited by hardware specifications. So to store large amount of data, multiple nodes are needed which occur in distributed environment.

### Key Value store based on client-server architecture 

- Multiple clients will be communicating with a coordinating server.
- Slave machine store the actual data and based on consistent hashing requests is routed to each of these nodes by a centralized server a.k.a. coordination server.
- Messages are transferred in JSON based message format and send the data through sockets using TCP channel between client, server and slaves nodes.
- Data replication is done with a default replication factor of 3
- In case of failure of slave nodes, data is synced with remaining nodes and system functions in a fault tolerant manner.
