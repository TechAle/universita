% Condello Alessandro 887918
function out_t = mygreythresh(image) 
    % Calcolo l'istogramma per le probabilità
    hist = imhist(image);
    % Idem
    pixels = numel(image);
    % Prendo il pixel con più intensità
    L = max(image(:));
    % Per trovare il valore massimo di T
    maxValue = -inf;
    for t=1:256
        % Calcolo tutto ciò che è necessario per la formula
        tempW0 = w0(t, hist, pixels);
        tempW1 = w1(t, hist, pixels, L);
        tempG0 = g0(t, hist, tempW0, pixels);
        tempG1 = g1(t, hist, tempW1, pixels, L);
        % Applico la formula
        result = tempW0*tempW1*(tempG0*tempG1)^2;
        % Controllo se è il massimo
        if result > maxValue
            maxValue = result;
            out_t = t;
        end
    end
end

function p = calculatep(pixel, hist, max)
    p = hist(pixel)/max;
end

function resultw0 = w0(t, hist, max)
    resultw0 = 0;
    for i=1:t-1
        resultw0 = resultw0 + calculatep(i, hist, max);
    end
end

function resultw1 = w1(t, hist, max, L)
    resultw1 = 0;
    for i=t:L-1
        resultw1 = resultw1 + calculatep(i, hist, max);
    end
end

function resultg0 = g0(t, hist, w0val, max)
    resultg0 = 0;
    for i=1:t-1
        resultg0 = resultg0 + calculatep(i, hist, max)*i/w0val;
    end
end

function resultg1 = g1(t, hist, w1val, max, L)
    resultg1 = 0;
    for i=t:L-1
        resultg1 = resultg1 + calculatep(i, hist, max)*i/w1val;
    end
end