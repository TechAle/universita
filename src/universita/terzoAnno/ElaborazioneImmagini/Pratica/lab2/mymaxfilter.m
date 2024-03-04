% Condello Alessandro 887918
function out_filtered = mymaxfilter(input_image, neighborhood)
    % Ci è stato richiesto un intorno dispari
    if mod(neighborhood, 2) == 0
        error("La dimensione dell'intorno deve essere dispari.");
    end

    % Converto l'immagine in double
    input_image = im2double(input_image);

    % Dimensioni dell'immagine di input
    [image_height, image_width, num_channels] = size(input_image);

    % Inizializza l'immagine di output
    out_filtered = zeros(image_height, image_width, num_channels);

    % Calcola il margine dell'intorno
    margin = (neighborhood - 1) / 2;

    % Itera su ogni pixel dell'immagine
    for i = 1:image_height
        for j = 1:image_width
            max = input_image(i, j, :);
            % Controllo a sinistra ed a destra
            for k=i-margin:i+margin
                if k > 0 && k <= image_height
                    for h=j-margin:j+margin
                        if h > 0 && h <= image_width
                            for dim=1:num_channels
                                if input_image(k, h, dim) > max(dim)
                                    max(dim) = input_image(k, h, dim);
                                end
                            end
                        end
                    end
                end
            end
            % Forse avrei dovuto fare la stessa cosa 

            % Assegna il valore massimo all'output
            out_filtered(i, j, :) = max;
        end
    end
end
