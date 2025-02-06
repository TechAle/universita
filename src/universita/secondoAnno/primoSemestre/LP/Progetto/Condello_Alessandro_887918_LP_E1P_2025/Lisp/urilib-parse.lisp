;;; Bonfanti Omar 879322
;;; Condello Alessandro 887918
;;; Dozio Luca 866375

;;; -*- Mode: Lisp -*-

;; Struttura dati che ritorneremo
(defclass urilib-structure ()
  ((scheme
    :accessor accessScheme
    :initarg :scheme
    :initform nil)
   (authority
    :accessor accessAuthority
    :initarg :authority
    :initform nil)
   (host
    :accessor accessHost
    :initarg :host
    :initform nil)
   (port
    :accessor accessPort
    :initarg :port
    :initform nil)
   (path
    :accessor accessPath
    :initarg :path
    :initform nil)
   (query
    :accessor accessQuery
    :initarg :query
    :initform nil)
   (fragment
    :accessor accessFragment
    :initarg :fragment
    :initform nil)))

;; Funzione per appiattire una lista
;; [[1] 2 3 [[4] 5]] -> [1 2 3 4 5]
(defun flatten (x)
  (cond 
    ((null x) x)
    ((atom x) (list x))
    (T (append (flatten (first x))
               (flatten (rest x))))))

;; Funzione per splittare prima occorrenza un array dato un delimitatore
;; [A B . C D . E] -> [[A B] [C D . E]]
(defun splitNext (inArray delimiter &rest output)
  (if (endp inArray)  
    (list (reverse (flatten output)) nil)  
    (if (eql (car inArray) delimiter) 
      (list (reverse (flatten output)) (cdr inArray)) 
      (splitNext (cdr inArray) delimiter (cons (car inArray) 
                                               output)))))

;; Funzione per splittare un array dato un delimitatore
;; [A . B C . E] -> [[A] [B C] [E]]
(defun split (input delimiter)
  (if (endp input)
    nil
    (let* ((nextSplit (splitNext input delimiter))
           (left (car nextSplit))
           (right (cadr nextSplit)))
      (if (and (char= delimiter (car (last input)))
               (endp right))
        (cons left (list nil))
        (cons left (split right delimiter))))))

;; Funzione che risponde se un array inizia con N caratteri
;; Ritorna [bool nuovo_array]
(defun starts-with-n (input character n)
  (if (= n 0)
    (list T input)
    (let* ((results (starts-with input character))
           (success (car results))
           (newInput (cadr results)))
      (if success
        (starts-with-n newInput character (- n 1))
        (list nil input)))))

;; Funzione che risponde se un array inizia con carattere
;; Ritorna [bool nuovo_array]
(defun starts-with (input character)
  (if (endp input)
    (list nil input)
    (if (char= (car input) character)
      (list T (cdr input))
      (list nil input))))

;; Funzione che ritorna T/nil a seconda se e una lettera l'input
(defun is-lettera (char)
  (or (and (char>= char #\A) (char<= char #\Z))  
      (and (char>= char #\a) (char<= char #\z)))) 

;; Funzione che ritorna T/nil a seconda se e un numero l'input
(defun is-digit (char)
  (and (char>= char #\0) (char<= char #\9)))

;; Funzione che ritorna T/nil a seconda se e un carattere l'input
(defun is-carattere (char)
  (or (is-lettera char)
      (is-digit char)
      (char= char #\_)
      (char= char #\=)
      (char= char #\+)
      (char= char #\-)))

;; Funzione che ritorna T/nil a seconda se e alfanumerico l'input
(defun is-alfanum (char)
  (or (is-lettera char)
      (is-digit char)))

;; Funzione che, dato un array di caratteri ed un carattere C
;; Ritorna l'array con nessuna occorrenza di C
(defun remove-character-from-array (char-array char-to-remove)
  (coerce (remove char-to-remove (coerce char-array 'string)) 'list))

;; Dato un array di carattere, ritorna se tutti i valori sono interi
(defun inside-all-digits(input)
  (if (endp input)
    T
    (if (is-digit (car input))
      (inside-all-digits (cdr input))
      nil)))

;; Dato un array di caratteri, ritorna il valore intero
;; Questa e una funzione di appoggio
(defun get-number (input)
  (if (endp input)
    0
    (get-number-reverse (reverse input))))

;; Data un array di interi gia specchiato
;; Ritorna l'intero (non specchiato)
(defun get-number-reverse (input)
  (if (endp input)
    0
    (+ (* 10 (get-number-reverse (cdr input))) 
       (parse-integer (string (car input))))))

;; Controlla se un array di caratteri e fatto da tutti numeri
(defun all-digits(input)
  (if (endp input)
    T
    (if (inside-all-digits (car input))
      (all-digits (cdr input))
      nil)))

;; Funzione che, dato un array di caratteri ed un delimitatore
;; Quando viene trovato il delimitatore, chiama la funzione process-fn
;; Oppure viene chiamata quando chars e vuota
(defun split-once-no-errors (chars delimiters acc process-fn 
                              &key (add-value nil))
  (cond
    ;; Input vuoto
    ((null chars) (funcall process-fn (list (reverse acc) nil)))
    ;; Trovato limitatore
    ((if (listp delimiters)
         (member (car chars) delimiters)
         (char= (car chars) delimiters)) 
     (funcall process-fn (list (reverse acc) 
                            (if add-value chars (cdr chars)))))
    ;; Deve continuare
    (t (split-once-no-errors (cdr chars) delimiters (cons (car chars) 
        acc) process-fn :add-value add-value))))

;; Funzione simile a split-once-no-errors
;; Se pero il delimitatore non viene trovato, chiama error-fn
(defun split-once (chars delimiters acc process-fn error-fn 
                        error-message)
  (cond
    ((null chars) (funcall error-fn error-message))
    ((if (listp delimiters)
         (member (car chars) delimiters)
         (char= (car chars) delimiters)) 
     (funcall process-fn (list (reverse acc) (cdr chars))))
    (t (split-once (cdr chars) delimiters (cons (car chars) acc) 
        process-fn error-fn error-message))))

;; Funzione per controllare che, un array di caratteri
;; rispecchia i requisiti dati in input
(defun check-element (sublist &key (allowLetter nil) 
                                  (allowDigit nil) 
                                  (allowCharacter nil))
  ;; Questo if iniziale serve per semplificare
  (if (and allowCharacter (or (not allowLetter) (not allowDigit)))
    (check-element sublist :allowLetter T :allowDigit T 
                          :allowCharacter T)
    (if (endp sublist)
      t 
      (let ((char (car sublist)))
        (cond
          ;; Controllo lettera
          ((and (is-lettera char) allowLetter) 
            (check-element (cdr sublist)
              :allowLetter allowLetter
              :allowDigit allowDigit
              :allowCharacter allowCharacter))
          ;; Controllo numero
          ((and (is-digit char) allowDigit) 
            (check-element (cdr sublist)
              :allowLetter allowLetter
              :allowDigit allowDigit
              :allowCharacter allowCharacter))
          ;; Controllo carattere
          ((and (is-carattere char) allowCharacter) 
            (check-element (cdr sublist)
              :allowLetter allowLetter
              :allowDigit allowDigit
              :allowCharacter allowCharacter))
          ;; Non e valido
          (t nil))))))

;; Funzione per controllare se un ip è corretto
;; Questa serve per lo più come primo controllo 
;; Per smistare da ipv4 e normal-ip
;; Se il nostro input permette i numeri
(defun is-ip-correct (input &key (allowLetter nil) (allowDigit nil) 
                                (allowCharacter nil))
  (if (endp input)
    0 ;; Un IP vuoto non è accettabile
    (if allowDigit
      (check-ipv4 input :allowLetter allowLetter :allowDigit allowDigit 
                        :allowCharacter allowCharacter)
      (check-normal-ip input :allowLetter allowLetter 
                            :allowDigit allowDigit 
                            :allowCharacter allowCharacter))))

;; Secondo controllo se l'input è un ipv4
;; Questa controlla solamente se la lunghezza dell'input è 4
(defun check-ipv4 (input &key (allowLetter nil) (allowDigit nil) 
                              (allowCharacter nil))
  (let ((len (length input)))
    (if (= len 4)
      (check-inside-ipv4 input :allowLetter allowLetter 
                              :allowDigit allowDigit 
                              :allowCharacter allowCharacter)
      (check-normal-ip input :allowLetter allowLetter 
                            :allowDigit allowDigit 
                            :allowCharacter allowCharacter))))

;; Funzione effettiva che controlla se un array di array di caratteri
;; E un ipv4. Controlla se tutti gli elementi sono < 256
(defun check-number-ipv4 (input)
  (if (endp input)
    T
    (if (<= (get-number (car input)) 255)
      (check-number-ipv4 (cdr input))
      nil)))

;; Funzione che, dato un array di array di caratteri, controlla che tutti
;; Sono dei numeri. Se falso, va a controllare se e un ip
(defun check-inside-ipv4 (input &key 
                          (allowLetter nil) 
                          (allowDigit nil) 
                          (allowCharacter nil))
  (let ((can-continue (all-digits input))) 
    (if can-continue
      (check-number-ipv4 input)
      (check-normal-ip input :allowLetter allowLetter 
                            :allowDigit allowDigit 
                            :allowCharacter allowCharacter))))

;; Funzione per controllare la correttezza di un ip
;; Input deve essere un array dia rray di caratteri
(defun check-normal-ip (input &key (allowLetter nil) 
                                  (allowDigit nil) 
                                  (allowCharacter nil)
                                  (started T))
  (if (endp input)
    t 
    (let ((current-sublist (car input)))
      (if (or (null (car (car input)))
          (and started (not(is-lettera  (car (car input))))))
        (error "Host deve iniziare con una lettera")
      )
      (if (or (null current-sublist) 
              (not (check-element current-sublist
                                  :allowLetter allowLetter
                                  :allowDigit allowDigit
                                  :allowCharacter allowCharacter)))
        nil 
        (check-normal-ip (cdr input)
                         :allowLetter allowLetter
                         :allowDigit allowDigit
                         :allowCharacter allowCharacter
                         :started nil)))))

;; Funzione per controllare che un array di caratteri e' una porta valida
(defun check-port (input)
  (if (endp input)
    nil
    (if (inside-all-digits input)
      (let ((port-value (get-number input)))
        (if (> port-value 65535)
          nil
          port-value))
      nil)))

;; Funzione che, dato un input con host-path
;; Li divide e poi chiama le rispettive funzioni per gestirli
(defun check-host-path (input)
  (let ((host (car input))
        (path (cadr input)))
    (cons (parse-full-host host '()) 
          (parse-new-path path '()))))

;; Funzione che controlla se id8 e corretto
(defun check-id8-new (input starting-len &key (counter 8) acc
                                              (started T))
  (if (= counter -1)
    (error "id8 troppo lungo")
  )
  (if (endp input)
      (error "id8 deve finire con )")
      (let ((carattere (car input)))
        (cond
          ((char= carattere #\))
           (if (or (= starting-len (length acc)) 
                   (> (length input) 1))
               (error "id8 non ben formattato")
               (coerce (reverse (cons carattere acc)) 'string)))
          (t
           (if (and started (is-digit carattere))
            (error "id8 non puo iniziare con un numero")
           )
           (if (is-alfanum carattere)
               (check-id8-new (cdr input) starting-len 
                :counter (1- counter) :acc (cons carattere acc)
                :started nil)
               (error "Carattere non valido in id8")))))))

;; Funzione per controllare se id44 e corretta
(defun check-id44-new (input &key (counter 44) (acc '()) (started T))
  (if (endp input)
      (if (or (= (length acc) 0) (char= (car acc) #\.) )
        (error "id44 non ben formattato")
        (coerce (reverse acc) 'string)
      )
      (let ((carattere (car input)))
        (cond
          ((char= #\( carattere)
           (check-id8-new (cdr input) (+ (length acc) 1) 
              :acc (cons carattere acc)))
          ((= counter 0)
           (error "id44 troppo grande"))
          ((char= #\. carattere)
            (if started
              (error "Non puo iniziare con . id44"))
           (check-id44-new (cdr input) :counter (1- counter) 
                                      :acc (cons carattere acc)
                                      :started nil))
          (t
           (if (and started (is-digit carattere))
            (error "id44 non puo iniziare con un numero")
           )
           (if (is-alfanum carattere)
               (check-id44-new (cdr input) :counter (1- counter) 
                                          :acc (cons carattere acc)
                                          :started nil)
               (error "Carattere non valido")))))))

;; Funzione pre controllare se il path e corretto
(defun check-slash-path(input zos)
  (if zos
    ;; Se e zos, allora controlla id44
    (check-id44-new input)
    (if (check-element (remove-character-from-array input #\/) 
        :allowCharacter T)
        (if (and (> (length input) 0)
            (char= (car input) #\/))
          (error "Il path deve iniziare con un identificatore")
          (coerce input 'string))
      (error "Path incorretto"))))

;; Funzione per controllare se la query e corretta
(defun check-question-path(input)
  (if (or (null input) (= (length input) 0))
    (error "Query deve essere almeno 1 di lunghezza")
  )
  (if (check-element input :allowCharacter T)
    (coerce input 'string)
    (error "Query incorretto")))

;; Funzione per controllare se il framment e corretto
(defun check-frag-path(input)
  (if (or (null input) (= (length input) 0))
    (error "Fragment deve essere almeno 1 di lunghezza")
  )
  (if (check-element input :allowCharacter T)
    (coerce input 'string)
    (error "Fragment incorretto")))

;; Funzione main per controllare tutto il path
(defun parse-new-path (sinistra destra &key (stage 0) (zos nil))
  (let ((carattere (car sinistra)))
    (cond
      ;; Se siamo alla fine, salva cosa abbiamo trovato
      ((not carattere)
       (cond
         ((= stage 1) (list 4 (check-slash-path (reverse destra) zos)))
         ((= stage 2) (list 5 (check-question-path (reverse destra))))
         ((= stage 3) (list 6 (check-frag-path (reverse destra))))))
      ;; Stato 0, vuol dire deve comprendere cosa dobbiamo controllare
      ((= stage 0)
       (cond
         ((char= carattere #\/) (parse-new-path (cdr sinistra) 
                                  destra :stage 1 :zos zos))
         ((char= carattere #\?) (parse-new-path (cdr sinistra) 
                                  destra :stage 2))
         ((char= carattere #\#) (parse-new-path (cdr sinistra) 
                                  destra :stage 3))
         ;; Qui non ci dovrebbe mai tornare inteoria
         (t (parse-new-path (cdr sinistra) destra :stage 0))))
      ;; Controllo query prima slash
      ((and (= stage 1) (char= carattere #\?))
       (cons (list 4 (check-slash-path (reverse destra) zos))
             (parse-new-path (cdr sinistra) '() :stage 2)))
      ;; Controllo fragment prima slash
      ((and (= stage 1) (char= carattere #\#))
       (cons (list 4 (check-slash-path (reverse destra) zos))
             (parse-new-path (cdr sinistra) '() :stage 3)))
      ;; Controllo fragment prima query
      ((and (= stage 2) (char= carattere #\#))
       (cons (list 5 (check-question-path (reverse destra)))
             (parse-new-path (cdr sinistra) '() :stage 3)))
      ;; Continua a scannare
      (t
       (parse-new-path (cdr sinistra) (cons carattere destra) 
        :stage stage 
        :zos zos)))))

;; Funzione per controllare userinfo
(defun parse-userinfo-new (userinfo)
  (if (endp userinfo)
    nil
     (if (check-element (remove-character-from-array userinfo #\:) 
          :allowCharacter T)
      (coerce userinfo 'string)
      nil)))

;; Funzione per dividere l'host in userinfo e ip
;; Stesso meccanismo di split-once
(defun parse-full-host (sinistra destra &key (found nil))
  (cond
    ((null sinistra) (parse-full-hosthost (reverse destra)))
    ((char= (car sinistra) #\@)
       (if found 
        (error "Errore carattere"))
        (if (null destra)
          (error "Userinfo vuota")
        )
        (let
          ((userinfo-output (parse-userinfo-new (reverse destra))))
          (if (null userinfo-output)
            (error "Userinfo sbagliata")
            (cons (list 1 (parse-userinfo-new (reverse destra)))
              (parse-full-host (cdr sinistra) '() :found T)))))
    (t (parse-full-host (cdr sinistra) (cons (car sinistra) destra) 
          :found found))))

;; Funzione per controllare se un ip e valido
(defun parse-ip-new(input)
  (let* ((ip-splitted (split input '#\.))
         (is-host-valid (is-ip-correct ip-splitted
                                       :allowLetter T
                                       :allowDigit T
                                       :allowCharacter T)))
    (if (and is-host-valid (
         or (not (integerp is-host-valid)) (not (= is-host-valid 0)) ))
      (coerce input 'string)
        (error "Host non valido"))))

;; Funzione appoggio per controllare la validita di una porta
(defun parse-port-new(input)
  (let ((newPort (check-port input)))
   (if newPort 
     newPort
     (error "Error port"))))

;; Funzione appoggio per parse-full-ip
(defun parse-full-hosthost (host)
  (parse-full-ip host '()))

;; Funzione main per fare il parsing di http
(defun parse-http (input)
  (let* ((inArray (coerce input 'list))
         (new-no-slash (starts-with-n inArray #\/ 2))
         (results-no-slash (car new-no-slash))
         (absolute-path (cadr new-no-slash)))
    (if results-no-slash
        (split-once-no-errors absolute-path '(#\/ #\? #\#) '() 
          #'check-host-path :add-value T)
        (if (= 0 (length input))
          nil
          (error "Slash sbagliate")
        )
        )))

;; Funzione main per fare il parsing di mailto
(defun parse-mailto (input)
  (let* ((inArray (coerce input 'list))
         (new-no-slash (starts-with-n inArray #\/ 2))
         (results-no-slash (car new-no-slash))
         (absolute-path (cadr new-no-slash)))
    (if results-no-slash
        (split-once absolute-path '(#\@) '() #'process-maito-userinfo 
          #'error-handler "Delimiter not found in maito")
        nil)))

;; Funzione per processare userinfo in mailto
(defun process-maito-userinfo(input)
  (let ((userinfo (car input))
        (host (cadr input)))
    (let ((user-info-value (parse-userinfo-new userinfo)))
      (if (null user-info-value)
          (error "userinfo obbligatorio in mailto")
          (cons (list 1 user-info-value)
                (parse-full-ip host '()))))))

;; Funzione per dividere host in ip e porta
(defun parse-full-ip (sinistra destra &key (found nil))
  (cond
    ((null sinistra) (if found
      (parse-port-new (reverse destra))
      (list 2 (parse-ip-new (reverse destra)))))
    ((char= (car sinistra) #\:)
       (if found (error "Errore carattere"))
         (cons
          (list 2 (parse-ip-new (reverse destra)))
          (list 3 (parse-full-ip (cdr sinistra) '() :found T))))
    (t (parse-full-ip (cdr sinistra) (cons (car sinistra) destra) 
        :found found))))

;; funzione per controllare ip in mailto
(defun parse-new-ip-mailto(sinistra destra &key (found nil))
  (cond
    ((null sinistra) (if found
      (parse-port-new (reverse destra))
      (list 2 (parse-ip-new-mailto (reverse destra)))))
    ((char= (car sinistra) #\:)
       (if found (error "Errore carattere"))
       (cons 
        (list 2 (parse-ip-new-mailto (reverse destra)))
        (list 3 (parse-full-ip (cdr sinistra) '() :found T))))
    (t (parse-full-ip (cdr sinistra) (cons (car sinistra) destra) 
        :found found))))

;; Funzione per fare il parsing dell'ip in mailto
(defun parse-ip-new-mailto(input)
  (let* ((ip-splitted (split input '#\.))
         (is-host-valid (is-ip-correct ip-splitted
                                       :allowLetter T
                                       :allowDigit T
                                       :allowCharacter T)))
    (if (and is-host-valid (
         or (not (integerp is-host-valid)) (not (= is-host-valid 0)) ))
      (coerce input 'string)
      (error "Host non valido"))))

;; Funzione per fare il parsing di news
;; Alla fine news e lo stesso di mailto per ip
(defun parse-news (input)
  (parse-new-ip-mailto input '()))

;; Funzione main per fare il parsing di tel
(defun parse-tel (input)
  (let* ((new-no-slah (starts-with input '#\+))
         (new-value (cadr new-no-slah)))
    (if (inside-all-digits new-value)
      (list 1 (list (coerce new-value 'string)))
      (error "Ci sono non numeri nel tel"))))

;; Funzione per controllare host e path in zos
; TODO path obbligatorio in zos
(defun check-host-path-zos (input)
  (let ((host (car input))
        (path (cadr input)))
    (cons (parse-full-host host '())
          (parse-new-path path '() :zos T))))

;; Funzione main per fare il parsing di zos
(defun parse-zos (input)
  (let* ((inArray (coerce input 'list))
         (new-no-slash (starts-with-n inArray #\/ 2))
         (results-no-slash (car new-no-slash))
         (absolute-path (cadr new-no-slash)))
    (if results-no-slash
        (split-once-no-errors absolute-path '(#\/ #\? #\#) '() 
            #'check-host-path-zos :add-value T)
        nil)))

;; Funzione per gestire i vari schemi
(defun process-remainder (remainder)
  (let* ((scheme (coerce (car remainder) 'string))
         (remaingUri (cadr remainder))
         (remaining-results (cond
                   ((string= scheme "https") (parse-http remaingUri))
                   ((string= scheme "http") (parse-http remaingUri))
                   ((string= scheme "ftp") (parse-http remaingUri))
                   ((string= scheme "mailto") (parse-mailto remaingUri))
                   ((string= scheme "news") (parse-news remaingUri))
                   ((string= scheme "tel") (parse-tel remaingUri))
                   ((string= scheme "fax") (parse-tel remaingUri))
                   ((string= scheme "zos") (parse-zos remaingUri))
                   (t (error "Unknown scheme") 
                    (setf (accessScheme) nil))))
          ;; Ci aggiungo lo scheme
         (result (cons (list 0 scheme) remaining-results)))
    ;; Sistemo i vari risultati e poi li salvo
    (create-uri-structure (flatten result))))

;; Funzione per sistemare i risultati bene in un array
;; Per facilitarmi nel salvataggio
;; Stato -1 equivale a sto cercando il nuovo stato
;; ogni stato rappresenta una field della struttura
(defun riordina-valori (input &key (stato -1) (results (make-array 7 
                                                :initial-element nil)))
  (if (endp input)
      results
      (cond 
        ((= stato -1)
         (riordina-valori (cdr input) :stato (car input) 
                                      :results results))
        (t
         (replace results (list (car input)) :start1 stato 
                                            :end1 (1+ stato))
         (riordina-valori (cdr input) :stato -1 :results results)))))

;; Funzione per creare l'output
(defun create-uri-structure (input)
  (let* ((ordered-input (riordina-valori input))
         (scheme (aref ordered-input 0))
         (authority (aref ordered-input 1))
         (host (aref ordered-input 2))
         ;; Qui gestisco l'opzionalita della porta
         (port (if (and (null (aref ordered-input 3)) 
                        (not (or (string= scheme "tel") 
                        (string= scheme "fax") (null host))))
                   80
                   (aref ordered-input 3)))
         (path (aref ordered-input 4))
         (query (aref ordered-input 5))
         (fragment (aref ordered-input 6)))
    (if (or
      (and (string= scheme "zos") (null path))
      (and (string= scheme "mailto") (null authority))
      (and (string= scheme "tel") (null authority))
      (and (string= scheme "fax") (null authority))
      (and (string= scheme "news") (null host)))
      (error "Qualcosa di obbligatorio non e stato inserito"))
    (make-instance 'urilib-structure
                   :scheme scheme
                   :authority authority
                   :host host
                   :port port
                   :path path
                   :query query
                   :fragment fragment)))

(defun error-handler (message)
  (error message))

;; Funzione main per il parsing di tutto
(defun urilib-parse (input)
  (let* ((inArray (coerce input 'list)))
     (split-once inArray '(#\:) '() #'process-remainder 
                          #'error-handler "Delimiter not found in URI")))

;; Da ora in poi ci saranno i vari metodi per accedere alla struttura dati
(defmethod urilib-scheme ((uri urilib-structure))
  (accessScheme uri))

;; Funzione per accedere all'host
(defmethod urilib-host ((uri urilib-structure))
  (if (null (accessHost uri))
    nil
    (accessHost uri)))
    
(defmethod urilib-userinfo ((uri urilib-structure))
  (if (null (accessAuthority uri))
    nil
    (accessAuthority uri)))

;; Funzione per accedere al port
(defmethod urilib-port ((uri urilib-structure))
  (if (null (accessPort uri))
    nil
    (accessPort uri)))

;; Funzione per accedere al path
(defmethod urilib-path ((uri urilib-structure))
  (if (null (accessPath uri))
    nil
    (accessPath uri)))

;; Funzione per accedere al query
(defmethod urilib-query ((uri urilib-structure))
  (if (null (accessQuery uri))
    nil
    (accessQuery uri)))

;; Funzione per accedere al fragment
(defmethod urilib-fragment ((uri urilib-structure))
  (if (null (accessFragment uri))
    nil
    (accessFragment uri)))

(defun urilib-display (uri &optional (stream T))
  (format stream "Scheme:~10t~s~%" (urilib-scheme uri))
  (format stream "Userinfo:~10t~s~%" (urilib-userinfo uri))
  (format stream "Host:~10t~s~%" (urilib-host uri))
  (format stream "Port:~10t~s~%" (urilib-port uri))
  (format stream "Path:~10t~s~%" (urilib-path uri))
  (format stream "Query:~10t~s~%" (urilib-query uri))
  (format stream "Fragment:~10t~s~%" (urilib-fragment uri))
  (if (eq stream T)
    T
    (close stream)))

;(defparameter *inputGiven* "http://user:pass@host.it:9090/path?query#frag")
;(defparameter test (urilib-parse *inputGiven*))
;(urilib-display test)