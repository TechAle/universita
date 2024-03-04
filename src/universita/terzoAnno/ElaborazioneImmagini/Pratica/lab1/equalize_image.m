% Condello Alessandro 887918
function out_image = equalize_image(image)
     % Controllo che l'immagine abbia 1 sola dimensione
    if size(image, 3) ~= 1
        error("L'immagine non è a livelli di grigio");
    end

    cum_hist = mycumulativehist(image);
    cum_hist = cum_hist / (size(image, 1) * size(image, 2));

    out_image = uint8(255 * cum_hist(image + 1));
    
end