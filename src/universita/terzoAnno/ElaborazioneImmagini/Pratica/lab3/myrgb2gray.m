% Condello Alessandro 887918
function out_gray = myrgb2gray(image_rgb)

    if size(image_rgb, 3) ~= 3
        error("L'immagine non è RGB");
    end

    out_gray = 0.299 * image_rgb(:,:,1) + 0.587 * image_rgb(:,:,2) + 0.114 * image_rgb(:,:,3);
    out_gray = uint8(out_gray);
    
end