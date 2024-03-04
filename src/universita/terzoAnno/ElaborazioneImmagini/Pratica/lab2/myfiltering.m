% Condello Alessandro 887918
function output_image = myfiltering(image, filter)
    % Converto l'immagine in double
    image = im2double(image);

    % Prendo le dimensioni del filtro
    [filter_height, filter_width] = size(filter);

    % Prendo le dimensioni dell'immagine
    [image_height, image_width, num_channels] = size(image);

    % Inizializzo l'immagine output
    output_image = zeros(image_height, image_width, num_channels);

    % Itero per tutti i canali colori
    for channel = 1:num_channels
        % Prendo il canale di riferimento che usiamo come input
        current_channel = image(:, :, channel);

        % Initialize the filtered channel
        filtered_channel = zeros(image_height, image_width);

        % Itero per le dimensioni. Siccome nella consegna c'è scritto che
        % possiamo ignorare il calcolo quando il filtro potrebbe uscire
        % dall'immagine
        for i = filter_height:image_height-filter_height
            for j = filter_width:image_width-filter_width
                % Ed infine applico il filtro
                region = current_channel(i:i+filter_height-1, j:j+filter_width-1);

                filtered_channel(i, j) = sum(region(:) .* filter(:));
            end
        end

        % Modifico l'output con la nuova informazione
        output_image(:, :, channel) = filtered_channel;
    end
end
