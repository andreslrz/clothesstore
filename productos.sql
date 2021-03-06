PGDMP     
    3                y         	   productos    12.7    12.7 .    =           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            >           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            @           1262    16393 	   productos    DATABASE     ?   CREATE DATABASE productos WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';
    DROP DATABASE productos;
                postgres    false            ?            1259    16633    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    16569    tb_descuentos    TABLE     ?  CREATE TABLE public.tb_descuentos (
    id bigint NOT NULL,
    descuento double precision NOT NULL,
    inicio_vigencia date NOT NULL,
    fin_vigencia date NOT NULL,
    usuario_creacion character varying(20) NOT NULL,
    usuario_modificacion character varying(20) NOT NULL,
    fecha_creacion date NOT NULL,
    fecha_modificacion date NOT NULL,
    id_producto bigint,
    idproducto bigint NOT NULL
);
 !   DROP TABLE public.tb_descuentos;
       public         heap    postgres    false            ?            1259    16567    tb_descuentos_id_seq    SEQUENCE     }   CREATE SEQUENCE public.tb_descuentos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.tb_descuentos_id_seq;
       public          postgres    false    203            A           0    0    tb_descuentos_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.tb_descuentos_id_seq OWNED BY public.tb_descuentos.id;
          public          postgres    false    202            ?            1259    16585    tb_imagenes    TABLE     }  CREATE TABLE public.tb_imagenes (
    id bigint NOT NULL,
    base64 bytea NOT NULL,
    usuario_creacion character varying(20) NOT NULL,
    usuario_modificacion character varying(20) NOT NULL,
    "fecha_creacion_ date" integer NOT NULL,
    fecha_modificacion date NOT NULL,
    principal boolean NOT NULL,
    id_producto bigint NOT NULL,
    id_tipo_imagen bigint NOT NULL
);
    DROP TABLE public.tb_imagenes;
       public         heap    postgres    false            ?            1259    16583    tb_imagenes_id_seq    SEQUENCE     {   CREATE SEQUENCE public.tb_imagenes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.tb_imagenes_id_seq;
       public          postgres    false    205            B           0    0    tb_imagenes_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.tb_imagenes_id_seq OWNED BY public.tb_imagenes.id;
          public          postgres    false    204            ?            1259    16596 
   tb_precios    TABLE     ?  CREATE TABLE public.tb_precios (
    id bigint NOT NULL,
    precio double precision NOT NULL,
    inicio_vigencia date NOT NULL,
    fin_vigencia date NOT NULL,
    usuario_creacion character varying(20) NOT NULL,
    usuario_modificacion character varying(20) NOT NULL,
    fecha_creacion date NOT NULL,
    fecha_modificacion date NOT NULL,
    id_producto bigint NOT NULL,
    producto bytea
);
    DROP TABLE public.tb_precios;
       public         heap    postgres    false            ?            1259    16594    tb_precios_id_seq    SEQUENCE     z   CREATE SEQUENCE public.tb_precios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.tb_precios_id_seq;
       public          postgres    false    207            C           0    0    tb_precios_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.tb_precios_id_seq OWNED BY public.tb_precios.id;
          public          postgres    false    206            ?            1259    16604    tb_producto    TABLE     ~  CREATE TABLE public.tb_producto (
    id bigint NOT NULL,
    nombre character varying(200) NOT NULL,
    numero_vistas bigint DEFAULT 0 NOT NULL,
    usuario_creacion character varying(20) NOT NULL,
    usuario_modificacion character varying(20) NOT NULL,
    fecha_creacion date NOT NULL,
    fecha_modificacion date NOT NULL,
    estado integer NOT NULL,
    idestado integer
);
    DROP TABLE public.tb_producto;
       public         heap    postgres    false            ?            1259    16602    tb_producto_id_seq    SEQUENCE     {   CREATE SEQUENCE public.tb_producto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.tb_producto_id_seq;
       public          postgres    false    209            D           0    0    tb_producto_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.tb_producto_id_seq OWNED BY public.tb_producto.id;
          public          postgres    false    208            ?            1259    16653    tb_tipo_imagen    TABLE     p   CREATE TABLE public.tb_tipo_imagen (
    id bigint NOT NULL,
    descripcion character varying(255) NOT NULL
);
 "   DROP TABLE public.tb_tipo_imagen;
       public         heap    postgres    false            ?            1259    16651    tb_tipo_imagen_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.tb_tipo_imagen_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.tb_tipo_imagen_id_seq;
       public          postgres    false    212            E           0    0    tb_tipo_imagen_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.tb_tipo_imagen_id_seq OWNED BY public.tb_tipo_imagen.id;
          public          postgres    false    211            ?
           2604    16572    tb_descuentos id    DEFAULT     t   ALTER TABLE ONLY public.tb_descuentos ALTER COLUMN id SET DEFAULT nextval('public.tb_descuentos_id_seq'::regclass);
 ?   ALTER TABLE public.tb_descuentos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202    203            ?
           2604    16588    tb_imagenes id    DEFAULT     p   ALTER TABLE ONLY public.tb_imagenes ALTER COLUMN id SET DEFAULT nextval('public.tb_imagenes_id_seq'::regclass);
 =   ALTER TABLE public.tb_imagenes ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            ?
           2604    16599    tb_precios id    DEFAULT     n   ALTER TABLE ONLY public.tb_precios ALTER COLUMN id SET DEFAULT nextval('public.tb_precios_id_seq'::regclass);
 <   ALTER TABLE public.tb_precios ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            ?
           2604    16607    tb_producto id    DEFAULT     p   ALTER TABLE ONLY public.tb_producto ALTER COLUMN id SET DEFAULT nextval('public.tb_producto_id_seq'::regclass);
 =   ALTER TABLE public.tb_producto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    209    209            ?
           2604    16656    tb_tipo_imagen id    DEFAULT     v   ALTER TABLE ONLY public.tb_tipo_imagen ALTER COLUMN id SET DEFAULT nextval('public.tb_tipo_imagen_id_seq'::regclass);
 @   ALTER TABLE public.tb_tipo_imagen ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    211    212            1          0    16569    tb_descuentos 
   TABLE DATA           ?   COPY public.tb_descuentos (id, descuento, inicio_vigencia, fin_vigencia, usuario_creacion, usuario_modificacion, fecha_creacion, fecha_modificacion, id_producto, idproducto) FROM stdin;
    public          postgres    false    203   z8       3          0    16585    tb_imagenes 
   TABLE DATA           ?   COPY public.tb_imagenes (id, base64, usuario_creacion, usuario_modificacion, "fecha_creacion_ date", fecha_modificacion, principal, id_producto, id_tipo_imagen) FROM stdin;
    public          postgres    false    205   ?8       5          0    16596 
   tb_precios 
   TABLE DATA           ?   COPY public.tb_precios (id, precio, inicio_vigencia, fin_vigencia, usuario_creacion, usuario_modificacion, fecha_creacion, fecha_modificacion, id_producto, producto) FROM stdin;
    public          postgres    false    207   ?8       7          0    16604    tb_producto 
   TABLE DATA           ?   COPY public.tb_producto (id, nombre, numero_vistas, usuario_creacion, usuario_modificacion, fecha_creacion, fecha_modificacion, estado, idestado) FROM stdin;
    public          postgres    false    209   9       :          0    16653    tb_tipo_imagen 
   TABLE DATA           9   COPY public.tb_tipo_imagen (id, descripcion) FROM stdin;
    public          postgres    false    212   _9       F           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 15, true);
          public          postgres    false    210            G           0    0    tb_descuentos_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.tb_descuentos_id_seq', 3, true);
          public          postgres    false    202            H           0    0    tb_imagenes_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tb_imagenes_id_seq', 1, false);
          public          postgres    false    204            I           0    0    tb_precios_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.tb_precios_id_seq', 3, true);
          public          postgres    false    206            J           0    0    tb_producto_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.tb_producto_id_seq', 1, false);
          public          postgres    false    208            K           0    0    tb_tipo_imagen_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.tb_tipo_imagen_id_seq', 3, true);
          public          postgres    false    211            ?
           2606    16574     tb_descuentos tb_descuentos_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.tb_descuentos
    ADD CONSTRAINT tb_descuentos_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.tb_descuentos DROP CONSTRAINT tb_descuentos_pkey;
       public            postgres    false    203            ?
           2606    16593    tb_imagenes tb_imagenes_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tb_imagenes
    ADD CONSTRAINT tb_imagenes_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.tb_imagenes DROP CONSTRAINT tb_imagenes_pkey;
       public            postgres    false    205            ?
           2606    16601    tb_precios tb_precios_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.tb_precios
    ADD CONSTRAINT tb_precios_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.tb_precios DROP CONSTRAINT tb_precios_pkey;
       public            postgres    false    207            ?
           2606    16612 "   tb_producto tb_producto_nombre_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT tb_producto_nombre_key UNIQUE (nombre);
 L   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT tb_producto_nombre_key;
       public            postgres    false    209            ?
           2606    16610    tb_producto tb_producto_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tb_producto
    ADD CONSTRAINT tb_producto_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.tb_producto DROP CONSTRAINT tb_producto_pkey;
       public            postgres    false    209            ?
           2606    16660 -   tb_tipo_imagen tb_tipo_imagen_descripcion_key 
   CONSTRAINT     o   ALTER TABLE ONLY public.tb_tipo_imagen
    ADD CONSTRAINT tb_tipo_imagen_descripcion_key UNIQUE (descripcion);
 W   ALTER TABLE ONLY public.tb_tipo_imagen DROP CONSTRAINT tb_tipo_imagen_descripcion_key;
       public            postgres    false    212            ?
           2606    16658 "   tb_tipo_imagen tb_tipo_imagen_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.tb_tipo_imagen
    ADD CONSTRAINT tb_tipo_imagen_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.tb_tipo_imagen DROP CONSTRAINT tb_tipo_imagen_pkey;
       public            postgres    false    212            ?
           2606    16640 &   tb_precios fklgf5tsptlw8ggmucy5f7suqgw    FK CONSTRAINT     ?   ALTER TABLE ONLY public.tb_precios
    ADD CONSTRAINT fklgf5tsptlw8ggmucy5f7suqgw FOREIGN KEY (id_producto) REFERENCES public.tb_producto(id);
 P   ALTER TABLE ONLY public.tb_precios DROP CONSTRAINT fklgf5tsptlw8ggmucy5f7suqgw;
       public          postgres    false    207    209    2730            ?
           2606    16635 (   tb_descuentos fkrdgr56dnsgq5qtan5tdrxoha    FK CONSTRAINT     ?   ALTER TABLE ONLY public.tb_descuentos
    ADD CONSTRAINT fkrdgr56dnsgq5qtan5tdrxoha FOREIGN KEY (id_producto) REFERENCES public.tb_producto(id);
 R   ALTER TABLE ONLY public.tb_descuentos DROP CONSTRAINT fkrdgr56dnsgq5qtan5tdrxoha;
       public          postgres    false    209    2730    203            ?
           2606    16661    tb_imagenes fktb_imagene741169    FK CONSTRAINT     ?   ALTER TABLE ONLY public.tb_imagenes
    ADD CONSTRAINT fktb_imagene741169 FOREIGN KEY (id_tipo_imagen) REFERENCES public.tb_tipo_imagen(id);
 H   ALTER TABLE ONLY public.tb_imagenes DROP CONSTRAINT fktb_imagene741169;
       public          postgres    false    212    205    2734            1      x?????? ? ?      3      x?????? ? ?      5   C   x?3??4 N##C]s]Cs??H?ؐ31/?(?8??
????44????2?44??q? ?b???? ŧ$?      7   H   x?34?,K-.?L?W(?/NL??4?L?K)J-?)?Bb???#39c??M?F?????nB? /?&      :   *   x?3?tO?K-J??2?tI?I?+r??9݊??J??1z\\\ ?i
?     