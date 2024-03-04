% Condello Alessandro 887918
function out_ycbcr = myRGB2YCbCr(image_rgb)
    
    if size(image_rgb, 3) ~= 3
        error("L'immagine non è RGB");
    end

    % Converto l'immagine in double
    image_rgb = im2double(image_rgb);
    
    m1 = [16,128,128];
    % uso la stessa matrice di trasformazione usata da matlab
    % con la matrice nel pdf non funziona
    m2 = [ 65.481 128.553 24.966; -37.797 -74.203 112; 112 -93.786 -18.214];
    
    
    
    out_ycbcr = reshape(image_rgb, [], 3);
    out_ycbcr = m2 * out_ycbcr';
    out_ycbcr = out_ycbcr + repmat(m1', 1, size(out_ycbcr, 2));
    
    out_ycbcr = reshape(uint8(out_ycbcr'), size(image_rgb));
    
end