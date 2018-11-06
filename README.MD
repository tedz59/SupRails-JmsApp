### SUPRAILS - JMS

#### Configuration de l'ide (Intellij idea)

* Cliquez sur src > Mark directory as > Sources root (si ce dossier n'est pas bleu)
* Ouvrez la configuration du projet (clic droit sur le nom du projet, open module settings)
* Créez un dossier out a la racine du projet.
* Dans l'onglet Project, selectionnez une oracle JDK 8 avec le même language level.
* Dans project compiler output selectionnez le dossier out créé ci-dessus. (si ce champ n'est pas déja rempli)
* Dans L'onglet module puis dependencies ajoutez le dossier dist/lib (en tant de dossier de jar)
* Ajoutez les jars suivants provenant de votre glassfish installé sur votre poste : 
** <glassfish_installation_path>/glassfish/lib/gf-client.jar
** <glassfish_installation_path>/glassfish/lib/javaee.jar
** <glassfish_installation_path>/glassfish/modules/javax.jms-api.jar
* Demarrez le main de la classs PrinterApplication.
* Démarrez le main de la classe SendMessageApplication.
* Regardez les logs des deux applications.