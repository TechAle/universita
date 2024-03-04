% Condello Alessandro 887918
function imgOut = labelling4(imgIn)
    idxArray = 0;

    % Creiamo l'output
    [image_height, image_width, num_channels] = size(imgIn);
    imgOut = zeros(image_height, image_width, num_channels);

    % Iteriamo per tutta la matrice
    for i=1:image_height
        for j=1:image_width
            % Prendiamo il colore corrente
            currentCol = imgIn(i, j, :);
            % Si parte col presupposto che non troveremo nulla
            idCurrent = idxArray;
            found = 0;
            % Se possiamo, controlliamo chi abbiamo a sinistra
            if j~=1
                % Se il colore è lo stesso
                colCheck = imgIn(i, j-1, :);
                if sum(currentCol==colCheck)==num_channels
                    % Sarà il nostro output
                    found = found + 1;
                    idCurrent = imgOut(i, j-1, 1);
                end
            end
            % Stesso ragionamento di sopra ma con il vicino in alto
            if i~=1
                colCheck = imgIn(i-1, j, :);
                if sum(currentCol==colCheck)==num_channels
                    idCurrent = imgOut(i-1, j, 1);
                    found = found + 1;
                end
            end
            % Se sia abbiamo lo stesso colore sia a sinistra che in alto
            if found == 2
                imgOut(i, j, :) = idCurrent;
                toChange1 = imgOut(i, j-1, 1);
                toChange2 = imgOut(i-1, j, 1);
                % Se per qualche motivo gli sono diversi, unifichiamoli
                % E per farlo sostituiamo tutti gli id
                if toChange2 ~= toChange1 
                    for k=1:i
                        for h=1:j
                            if imgOut(k, h, 1) == toChange1 || imgOut(k, h, 1) == toChange2
                                imgOut(k, h, :) = idCurrent;
                            end
                        end
                    end
                end
                % Se invece sono uguali, non abbiamo nulla da fare ai
                % vicini
                if toChange2 == toChange1
                    imgOut(i, j, :) = idCurrent;
                end
            end
            % Se invece invece non dobbiamo controllare i vicini
            if found ~= 2
                imgOut(i, j, :) = idCurrent;
            end
            % Se invece è una nuova zona
            if found == 0
                idxArray = idxArray + 1;
            end
        end
    end

    % Faccio si che i numeri non abbiano spazi tra di loro, es:
    % unique(imgOut) = (0, 2, 5, 6) -> (0, 1, 2, 3)
    uniqueValues = unique(imgOut);
    toDecrease = 0;
    for i = 2:length(uniqueValues)
        currentValue = uniqueValues(i);
        
        if (uniqueValues(i-1) - currentValue) ~=1
            toDecrease = toDecrease + currentValue - uniqueValues(i-1) - 1;
        end
        
        if toDecrease ~= 0
            imgOut(imgOut == currentValue) = currentValue - toDecrease;
        end
        
    end

end

