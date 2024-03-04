% Condello Alessandro 887918
function out_image = myresize(image,scale)
    % Converto l'immagine in double
    image = im2double(image);
    % Prendo le dimensioni della immagine corrente
    [original_height, original_width, num_channels] = size(image);

    % Calcolo le nuove dimensioni
    new_height = round(original_height * scale);
    new_width = round(original_width * scale);

    % Inizializzo l'output con le nuove dimensioni
    out_image = zeros(new_height, new_width, num_channels, class(image));

    % Calcolo il step con cui ci muoveremo nell'immagine
    step_row = original_height / new_height;
    step_col = original_width / new_width;

    % Itero per tutte le dimensioni
    for i = 1:new_height
        for j = 1:new_width
            % Calcolo le coordinate
            source_row = round((i - 0.5) * step_row + 0.5);
            source_col = round((j - 0.5) * step_col + 0.5);

            % Setto il colore alle nuove coordinate
            out_image(i, j, :) = image(source_row, source_col, :);
        end
    end
end

