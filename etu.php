<?php
    $filename = "conso.csv";

    $f = fopen($filename, 'r');
    if(!$f){
        die("Ouverture du fichier ".$filename." impossible."."\r\n");
    }


    $prec_sem = 1;

    while(!feof($f)){

        $line = trim(fgets($f));

        $res = explode(";", $line);

            $num_sem = $res[0];
            $machine = $res[1];
                $lettre = substr($machine, 0, 1);

            $arr_consoRes = $res[3];
                $val_consoRes = explode(" ", $arr_consoRes);

            $arr_consoStock = $res[4];
                $val_consoStock = explode(" ", $arr_consoStock);

            $sum = (float)$val_consoRes[0] + (float)$val_consoStock[0];

            //echo $num_sem.' '.$prec_sem."\r\n";

            if ($num_sem == $prec_sem){
                if ($lettre == "M"){
                    $energie += $sum;
                }
            } else {
                echo 'S'.$prec_sem.';'.$energie.' kWH'.';'."\r\n";
                if ($lettre == "M"){
                    $energie = $sum;
                    $prec_sem = $num_sem;
                }

            }

    }

    fclose($f);
 ?>
