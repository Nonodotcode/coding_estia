<?php
    $filename = "conso.txt";

    $f = fopen($filename, 'r');
    if(!$f){
        die("Ouverture du fichier ".$filename." impossible."."\r\n");
    }

    $nrj = 0;
    $prec_sem = 1;


    while(!feof($f)){

        $line = trim(fgets($f));

        $res = explode(";", $line);

            $num_sem = $res[0];
            $machine = $res[1];

            $arr_consoRes = $res[3];
                $val_consoRes = explode(" ", $arr_consoRes);

            $arr_consoStock = $res[4];
                $val_consoStock = explode(" ", $arr_consoStock);

            $unit = $val_consoRes[1];


            if(substr($machine, 0, 1) == "M"){
                $nrj = (float)$val_consoRes[0] + (float)$val_consoStock[0];
                if ($prec_sem != $num_sem){
                    $nrj_tot = $nrj;
                    $prec_sem = $num_sem;

                } else {
                    $nrj_tot += $nrj;
                }

            echo 'S'.$prec_sem.';'.$nrj_tot.' '.$unit.';'."\r\n";

            }


    }

    fclose($f);
 ?>
