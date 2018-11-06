### SUPRAILS - JMS

Cet projet permet de lancer un listener jms qui attend de recevoir des messages, puis les affiches une fois reçu.
Il permet aussi d'envoyer un message de test dans la queue jms.
Ce code est adapté à une queue Jms créé et lancé depuis un serveur glassfish 4.0.0 minimum.

#### Prés requis

* Avoir une JDK 1.8
* Avoir un serveur glassfish installé sur la machine
* Avoir un serveur glassfish lancé en local
* Avoir créé un ConnectionFactory dans l'interface d'admin de glassfish (nom par défaut : jms/suprailsConnectionFactory)
* Avoir créé une queue JMS dans l'interface d'admin de glassfish (nom par défaut : jms/suprailsQueue)

#### Configuration de l'ide (Intellij idea)

* Cliquez sur src > Mark directory as > Sources root (si ce dossier n'est pas bleu)
* Ouvrez la configuration du projet (clic droit sur le nom du projet, open module settings)
* Créez un dossier out a la racine du projet.
* Dans l'onglet Project, selectionnez une oracle JDK 8 avec le même language level.
* Dans project compiler output selectionnez le dossier out créé ci-dessus. (si ce champ n'est pas déja rempli)
* Dans L'onglet module puis dependencies ajoutez le dossier dist/lib (en tant de dossier de jar)
* Ajoutez les jars suivants provenant de votre glassfish installé sur votre poste : 
* <glassfish_installation_path>/glassfish/lib/gf-client.jar
* <glassfish_installation_path>/glassfish/lib/javaee.jar
* <glassfish_installation_path>/glassfish/modules/javax.jms-api.jar
