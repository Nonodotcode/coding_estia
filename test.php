<?php

$filename = 'conso.csv';

    $f = fopen($filename, 'r');
    $f1 = fopen("sem.txt", 'w');

    if (!$f){
        die ("Ouverture impossible");
    }

    if (!$f1){
        die ("Ouverture impossible");
    }

        // Numéro de semaine précédent
        $sem_avant = 1;

        while(!feof($f)){
            $line = trim(fgets($f));
            $arr = explode(";", $line);

                $sem = $arr[0];
                $arr_machine = $arr[1];
                    $lettre = substr($arr_machine[0], 0, 1);

                $arr_puissR = $arr[3];
                    $puissR = explode(" ",$arr_puissR);
                    $val_puissR = $puissR[0];
                    $unite = $puissR[1];

                $arr_puissS = $arr[4];
                    $puissS = explode(" ",$arr_puissS);
                    $val_puissS = $puissS[0];

                $sum_puiss = (float)$val_puissR + (float)$val_puissS;

                if($lettre == "M"){
                    if ($sem_avant == $sem){
                        $energie += $sum_puiss;
                    } else{
                        echo 'S'.$sem_avant.';'.$energie.' kWh'.';'."\r\n";
                        $energie = $sum_puiss;
                        $sem_avant = $sem;
                    }
                }
        }

    fclose($f);
    fclose($f1);
?>
