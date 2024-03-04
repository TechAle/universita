% Condello Alessandro 887918
function out_edges = myedge(image, threshold)
    
    if size(image, 3) == 3
        image = myrgb2gray(image);
    end

    % Converto l'immagine in double
    image = im2double(image);

    sobelX = [-1 0 1; -2 0 2; -1 0 1];
    sobelY = [-1 -2 -1; 0 0 0; 1 2 1];

    edges_x = imfilter(image, sobelX);
    edges_y = imfilter(image, sobelY);

    out_edges = sqrt(edges_y.^2 + edges_x.^2) > threshold;

end