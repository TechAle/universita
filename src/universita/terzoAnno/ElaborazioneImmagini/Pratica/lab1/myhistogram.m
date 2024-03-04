% Condello Alessandro 887918
function out_hist = myhistogram(image)
    % Controllo che l'immagine abbia 1 sola dimensione
    if size(image, 3) ~= 1
        error("L'immagine non è a livelli di grigio");
    end

    out_hist = zeros(256, 1);

    % Itero per tutte le dimensioni dell'immagine
    for i = 1:size(image, 1)
        for j = 1:size(image, 2)
            % Salvo il pixel
            temp = image(i, j);
            out_hist(temp + 1) = out_hist(temp + 1) + 1;
        end
    end

end