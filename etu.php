<?php
    $filename = "conso.csv";

    $f = fopen($filename, 'r');
    if(!$f){
        die("Ouverture du fichier ".$filename." impossible."."\r\n");
    }

    $file_write = "sem.txt";
    $fw = fopen($file_write,'w');
    if (!$fw){
        die ("Ouverture impossible du fichier ".$file_write." impossible."."\r\n");
    }

    // Sauvegarde de la ligne précédente
    $prec_sem = 1;
    $energie = 0;

    while(!feof($f)){
        $line = trim(fgets($f));
        //echo $line."\r\n";
        $res = explode(";", $line);
            $num_sem = $res[0];
            $machine = $res[1];
                $lettre = substr($machine, 0, 1);

            $arr_consoRes = $res[3];
                $val_consoRes = explode(" ", $arr_consoRes);

            $arr_consoStock = $res[4];
                $val_consoStock = explode(" ", $arr_consoStock);

            $sum = $val_consoRes[0] + $val_consoStock[0];

            //echo $num_sem.' '.$prec_sem."\r\n";
            if ($num_sem == $prec_sem){
                if ($lettre == "M"){
                    $energie += $sum;
                    $prec_sem = $num_sem;
                }
            } else {
            fputs($fw, 'S'.$prec_sem.';'.$energie.' kWH'.';'."\r\n");
            //echo 'S'.$prec_sem.';'.$energie.' kWH'.';'."\r\n";
                if ($lettre == "M"){
                    $energie = $sum;
                    $prec_sem = $num_sem;
                } else {
                    $prec_sem = 0;
                }
            }
    }
    fclose($f);
    fclose($fw);
?>
