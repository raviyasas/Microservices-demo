# Microservices-demo


#Basic APIs

a.	Eureka-service  http://localhost:8761/
b.	Work-order-service fallback method  http://localhost:8090/api/workOrder/fallBack
c.	Pro-launcher-service fallback method  http://localhost:8091/api/proLauncher/fallback
d.	Feign client demo  http://localhost:8090/api/workOrder/getWorkOrder
e.	Send a file using RabbitMQ  http://localhost:8091/api/proLauncher/rabbitMQ/sendFile
f.	Hystrix-dashboard  http://localhost:8099/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A8099%2Fturbine.stream
