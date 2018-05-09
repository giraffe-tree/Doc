# emqttd

## command

```
[root@iZbp193yy46icaga1srlt6Z ~]# emqttd_ctl
Usage: emqttd_ctl
--------------------------------------------------------------------------------
status                                          # Show broker status
--------------------------------------------------------------------------------
broker                                          # Show broker version, uptime and description
broker pubsub                                   # Show process_info of pubsub
broker stats                                    # Show broker statistics of clients, topics, subscribers
broker metrics                                  # Show broker metrics
--------------------------------------------------------------------------------
cluster join <Node>                             # Join the cluster
cluster leave                                   # Leave the cluster
cluster force-leave <Node>                      # Force the node leave from cluster
cluster status                                  # Cluster status
--------------------------------------------------------------------------------
users list                                      # List users
users add <Username> <Password>                 # Add User
users del <Username>                            # Delete User
--------------------------------------------------------------------------------
acl reload                                      # reload etc/acl.conf
--------------------------------------------------------------------------------
clients list                                    # List all clients
clients show <ClientId>                         # Show a client
clients kick <ClientId>                         # Kick out a client
--------------------------------------------------------------------------------
sessions list                                   # List all sessions
sessions list persistent                        # List all persistent sessions
sessions list transient                         # List all transient sessions
sessions show <ClientId>                        # Show a session
--------------------------------------------------------------------------------
routes list                                     # List all routes
routes show <Topic>                             # Show a route
--------------------------------------------------------------------------------
topics list                                     # List all topics
topics show <Topic>                             # Show a topic
--------------------------------------------------------------------------------
subscriptions list                              # List all subscriptions
subscriptions show <ClientId>                   # Show subscriptions of a client
subscriptions add <ClientId> <Topic> <QoS>      # Add a static subscription manually
subscriptions del <ClientId> <Topic>            # Delete a static subscription manually
--------------------------------------------------------------------------------
plugins list                                    # Show loaded plugins
plugins load <Plugin>                           # Load plugin
plugins unload <Plugin>                         # Unload plugin
--------------------------------------------------------------------------------
bridges list                                    # List bridges
bridges options                                 # Bridge options
bridges start <Node> <Topic>                    # Start a bridge
bridges start <Node> <Topic> <Options>          # Start a bridge with options
bridges stop <Node> <Topic>                     # Stop a bridge
--------------------------------------------------------------------------------
vm all                                          # Show info of Erlang VM
vm load                                         # Show load of Erlang VM
vm memory                                       # Show memory of Erlang VM
vm process                                      # Show process of Erlang VM
vm io                                           # Show IO of Erlang VM
vm ports                                        # Show Ports of Erlang VM
--------------------------------------------------------------------------------
mnesia                                          # Mnesia system info
--------------------------------------------------------------------------------
trace list                                      # List all traces
trace client <ClientId> <LogFile>               # Trace a client
trace client <ClientId> off                     # Stop tracing a client
trace topic <Topic> <LogFile>                   # Trace a topic
trace topic <Topic> off                         # Stop tracing a Topic
--------------------------------------------------------------------------------
listeners                                       # List listeners
listeners restart <Proto> <Port>                # Restart a listener
listeners stop    <Proto> <Port>                # Stop a listener
--------------------------------------------------------------------------------
recon memory                                    # recon_alloc:memory/2
recon allocated                                 # recon_alloc:memory(allocated_types, current|max)
recon bin_leak                                  # recon:bin_leak(100)
recon node_stats                                # recon:node_stats(10, 1000)
recon remote_load Mod                           # recon:remote_load(Mod)
--------------------------------------------------------------------------------
retainer info                                   # Show the count of retained messages
retainer topics                                 # Show all topics of retained messages
retainer clean                                  # Clean all retained messages
--------------------------------------------------------------------------------
admins add <Username> <Password> <Tags>         # Add dashboard user
admins passwd <Username> <Password>             # Reset dashboard user password
admins del <Username>                           # Delete dashboard user
```

```
./bin/emqttd_ctl plugins load emq_auth_username
```

## emqttd_bench

```
./emqtt_bench_sub -c 1000 -i 10 -t bench/%i -q 0 -u proton -P proton123

./emqtt_bench_sub -h 106.14.93.227 -p 1883 -c 500 -i 10 -t bench/%i -q 0 -u proton -P proton123

```

```
./emqtt_bench_pub -c 3000 -I 1000 -t bench/%i -s 256 -u proton -P proton123

./emqtt_bench_pub -h 106.14.93.227 -p 1883 -c 500 -I 1000 -t bench/%i -s 256 -u proton -P proton123
```

## 内存

```
free -m
``` 

2核 4G 

1000 1000 -> 35%  35% 

3000 3000 -> 95%  40% 

4000 4000 -> 99%  65% 









