<?php

    function energyPeak($filename){
        // Sauvegarder la valeur de la puissance
        $puissance_save = 0;

        $f = fopen($filename, 'r');

        if (!$f){
            die("Ouverture impossible du fichier ".$filename);
        }

        while (!feof($f)){
            $line = trim(fgets($f));

            $results = explode(";",$line);

            $heure = $results[0];
            $min = $results[1];
            $puissance = $results[2];
                $tab_unite = explode(" ", $puissance);
                $val_puiss = $tab_unite[0];
                $unite = $tab_unite[1];

            // Convertir dans la même unité
            if ($unite == "MW") {
                $uniteW = $val_puiss*1000000;
            } else if ($unite == "kW"){
                $uniteW = $val_puiss*1000;
            } else {
                $uniteW = $val_puiss;
            }



            if ($uniteW > $puissance_save){
                $puissance_save = $uniteW;
                $heure_save = $heure;
                $min_save = $min;
            }

        }

        fclose($f);
    return $heure_save.":".$min_save;

    }

?>
