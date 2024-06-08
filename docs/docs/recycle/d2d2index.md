# Convert your Docker Compose file to Kubernetes or OpenShift

An official Kubernetes project, located at github.com/kubernetes/kompose
Go from Docker Compose to Kubernetes.

<img src="/assets/imagery/cover.png">

Kompose is a conversion tool for Docker Compose to container orchestrators such as Kubernetes (or OpenShift).

``` bash 
$ kompose convert -f docker-compose.yaml

$ kubectl apply -f .

$ kubectl get po
NAME                            READY     STATUS              RESTARTS   AGE
frontend-591253677-5t038        1/1       Running             0          10s
redis-master-2410703502-9hshf   1/1       Running             0          10s
redis-replica-4049176185-hr1lr  1/1       Running             0          10s
```

<a href="guides/installation" class="class="btn btn-primary">
<button type="button" class="btn btn-primary">Installation Guide</button>
</a>

## Get started on Kubernetes immediately

So easy your human companion could do it too!

Why do cats (and developers) like Kompose?

Developers love to simplify their development environment with Docker Compose.

With Kompose, you can now push the same file to a production container orchestrator!

<a href="guides/getting-started" class="class="btn btn-primary">
<button type="button" class="btn btn-primary">Getting Started</button>
</a>

## Built for container engineers

Our conversions are not always 1-1 from Docker Compose to Kubernetes, but we will help get you 99% of the way there!

### The awesome features

* Compatibility with multiple versions of Docker Compose
* A conversion matrix that outlines all compatible values and versions

* Labels that provide the extra 1% needed to get to 1-1 conversion

<a href="guides/architecture" class="class="btn btn-primary">
<button type="button" class="btn btn-primary">Architecture Guide</button>
</a>

## Read The User Guide

Check out the in-depth user guide to use advanced features such as LoadBalancer, Service and TLS

<a href="guides/user" class="class="btn btn-primary">
<button type="button" class="btn btn-primary">User Guide</button>
</a>
