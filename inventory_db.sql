PGDMP  6    *                }         	   inventory    17.4    17.4 	               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false                        1262    24591 	   inventory    DATABASE     o   CREATE DATABASE inventory WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en-US';
    DROP DATABASE inventory;
                     postgres    false            �            1259    24603    product    TABLE     �   CREATE TABLE public.product (
    id bigint NOT NULL,
    name character varying(255),
    price double precision,
    weight double precision
);
    DROP TABLE public.product;
       public         heap r       postgres    false            �            1259    24602    product_id_seq    SEQUENCE     �   ALTER TABLE public.product ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public               postgres    false    218                      0    24603    product 
   TABLE DATA           :   COPY public.product (id, name, price, weight) FROM stdin;
    public               postgres    false    218   �       !           0    0    product_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.product_id_seq', 10, true);
          public               postgres    false    217            �           2606    24607    product product_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public                 postgres    false    218               �   x�%�A� D��O���V4�� n~i�(��K�b��fF��ࡘ[HcJ�@i�f��Bym���`��xH.��m&�[
�@��L\?[��V��0TC|C�����h��R�IV�;��6�Tz���W}&     