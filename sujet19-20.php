<?php

echo energyPeak('prev.csv');

function energyPeak($filename) {
  // Ouverture du fichier passé en paramètre en mode LECTURE ("r")
  $f = fopen($filename, "r");

  // Message d'erreur si pas d'ouverture du fichier
  if(!$f){
    die("Ouverture impossible.");
    }

  // var qui stocke la plus grand puissance au fur et à mesure qu'on lit le fichier
  $puissance = 0;

  // Lecture tant que le fichier n'est pas vide
    while(!feof($f)){
      $line = fgets($f);

      $res = explode(";", $line);
        $heure_tmp = $res[0];
        $min_tmp = $res[1];
        $puiss = $res[2];
        $puiss_tmp = explode(" ", $puiss);

        $str_puiss =substr($puiss_tmp[1],0,1);

      if ($str_puiss == "M"){
        $puiss_to_compare = $puiss_tmp[0]*1000;
      }
      else if ($str_puiss == 'W') {
        $puiss_to_compare = $puiss_tmp[0]/1000;
      }
      else {
        $puiss_to_compare = $puiss_tmp[0];
      }

      if($puiss_to_compare > $puissance){
        $puissance = $puiss_to_compare;
        $heure = $heure_tmp;
        $min = $min_tmp;
        $horaire = $heure.':'.$min;
      }

    }

  fclose($f);
  return $horaire;
}

?>
