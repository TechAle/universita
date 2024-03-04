% Condello Alessandro 887918
function out_cumhist = mycumulativehist(image)
    % Controllo che l'immagine abbia 1 sola dimensione
    if size(image, 3) ~= 1
        error("L'immagine non è a livelli di grigio");
    end

    % Preparo le variabili
    hist = myhistogram(image);
    out_cumhist = zeros(256, 1);

    % Salvo tutto
    out_cumhist(1) = hist(1);
    for i = 2:256
        out_cumhist(i) = out_cumhist(i-1) + hist(i);
    end

end