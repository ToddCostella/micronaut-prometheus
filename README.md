## Micro-Prometheus Goals

- Write a micronaut app that publishes prometheus metrics.
- Measure the number of method invocations (Maybe using AOP Around Advice?)
- Measure the duration average of those invocations
- Package and deploy the application to docker hub
- Pull package into kubernetes cluster
- Poke at the app to generate metrics (end point)
- See those metrics flow through kubernetes to prometheus
- Visualize metrics in Graphana 



### Setup
Install the latest version of Micronaut

```sdk i micronaut 2.0.0.RC2```

Generate a project with prometheus support

```mn create-app micro-prometheus --features micrometer-prometheus --lang groovy```


### Helm
```curl -fsSL -o get_helm.sh https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3
chmod +x get_helm.sh 
./get_helm.sh
helm repo add stable https://kubernetes-charts.storage.googleapis.com
helm repo update 
helm install stable/prometheus-operator --generate-name 
```



### Helm Chart
https://hub.helm.sh/charts/stable/prometheus-operator

## Feature http-client documentation

- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature management documentation

- [Micronaut Micronaut Management documentation](https://docs.micronaut.io/latest/guide/index.html#management)

