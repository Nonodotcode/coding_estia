<?php
$pathRead = 'conso.txt';
$pathWrite = 'sem.txt';

$fidRead = fopen($pathRead, 'r') ;
$fidWrite = fopen($pathWrite, 'w');

if (!$fidRead){
  die("Erreur d'ouverture du fichier $pathRead en lecture") ;
}
if (!$fidWrite){
  die("Erreur d'ouverture du fichier $pathWrite en ecriture");
}

//Variables
$puiHebdomadaire = 0;
$i = 1;

while (!feof($fidRead)){
  $ligne_courante = trim(fgets($fidRead));
  $tab = explode(';',$ligne_courante) ;

  $numSemaine = $tab[0];
  $type = substr($tab[1], 0, 1);
  $precyReseau = substr($tab[3],0 -4);
  $precyStockage = substr($tab[4], 0, -4);

  if ($numSemaine == $i) {
    if ($type == 'M'){
      $puiHebdomadaire = $puiHebdomadaire + $precyReseau + $precyStockage ;
    }
  }
  else{
    $i = $i+1;
    fputs ($fidWrite, 'S'.($numSemaine-1).';'.$puiHebdomadaire.' kWh;'."\r\n");
    $puiHebdomadaire = 0 ;
    if ($type == 'M'){
      $puiHebdomadaire = $puiHebdomadaire + $precyReseau + $precyStockage ;
    }
  }
}
?>
