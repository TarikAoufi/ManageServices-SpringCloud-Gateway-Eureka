# ManageServices-SpringCloud-Gateway-Eureka


Dans cette Démo, on montre comment gérer des micro-services avec Spring Cloud Gateway et Eureka Discovery.

Cette application est basée sur les services métiers : 

  •	Microservice Client : customer-service, pour gérer les clients.
  
  •	Microservice Produit : product-service, pour gérer les produits.
  
  •	Microservice Commande : ordering-service, pour gérer les commandes.
  
      1. Il permet de gérer la communication entre les deux microservices customer-service et product-service afin de récupérer 
         les informations sur le client et les produits d'une commande.
         
      2. La communication entre ces deux microservices est basée sur le Framework OpenFeign, qui permet de créer un Client REST 
         d'une manière déclarative.
        
L'orchestration des services se fait via les services techniques : 

•	Microservice eureka-discovery, basé sur Spring Cloud Discovery Eureka : pour le service annuaire d'enregistrement et de découverte 
   des services de l'application.

•	Microservice gateway, basé sur Spring Cloud Gateway : pour le service de proxy. Dans lequel, on montre comment configurer 
  Spring Cloud Gateway avec trois manières :

    1. Approche statique, en utilisant : Un fichier yaml pour le routage et une classe de configuration.
    
    2. Approche statique, via : Le service Eureka server, qui permet d’enregistrer automatiquement les noms des microservices 
       démarrés à partir d’une configuration.
       
    3. Approche dynamique : Création d'une configuration avec DiscoveryClientRouteDefinitionLocator.   
       Elle va récupérer le nom du microservice, contenu dans l’URL, et contact l'annuaire afin de récupérer toutes les informations 
       du service (l’adresse IP et le numéro de port).


URLs :

-	Service gateway :

  http://localhost:8888/CUSTOMER-SERVICE/customers
  
  http://localhost:8888/PRODUCT-SERVICE/products
    
  http://localhost:8888/ORDER-SERVICE/orders


-	Service eureka :

  http://localhost:8761


-	Service order :

  http://localhost:8083/orders
  
  http://localhost:8083/fullOrder/1


-	Service customer :

  http://localhost:8081/customers/


-	Service product :

  http://localhost:8082/products/ 
  
  
