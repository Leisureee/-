SET MODE MYSQL;

CREATE TABLE employee
(
    id     int UNSIGNED   NOT NULL AUTO_INCREMENT,
    eno    varchar(32)    NOT NULL,
    eclass varchar(16)    NOT NULL,
    ename  varchar(64)    NOT NULL,
    esex   varchar(6)     NULL DEFAULT NULL,
    eage   int            NULL DEFAULT NULL,
    ewage  decimal(16, 2) NOT NULL,
    etel   varchar(11)    NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE goods
(
    id     int UNSIGNED   NOT NULL AUTO_INCREMENT,
    gno    varchar(32)    NOT NULL,
    gname  varchar(64)    NOT NULL,
    gclass varchar(32)    NOT NULL,
    gprice decimal(16, 2) NULL DEFAULT NULL,
    gmix   decimal(16, 2) NULL DEFAULT NULL,
    gstnum int            NOT NULL,
    PRIMARY KEY (id),
    INDEX i_goods (gno)
);

CREATE TABLE purchase
(
    pfno   varchar(12)   NOT NULL,
    gno    varchar(12)   NOT NULL,
    gname  varchar(20)   NOT NULL,
    pnum   int           NOT NULL,
    pprice decimal(6, 2) NOT NULL,
    stsum  decimal(8, 2) NOT NULL,
    PRIMARY KEY (pfno)
);

CREATE TABLE storage
(
    stno   varchar(12)   NOT NULL,
    gno    varchar(12)   NOT NULL,
    gname  varchar(20)   NOT NULL,
    stnum  int           NOT NULL,
    stsum  decimal(8, 2) NOT NULL,
    stdate date          NOT NULL,
    PRIMARY KEY (stno),
    INDEX i_storage (stno, stdate, gno)
);

CREATE TABLE supplier
(
    spno   varchar(12) NOT NULL,
    spname varchar(10) NOT NULL,
    sptel  varchar(11) NOT NULL,
    PRIMARY KEY (spno)
);

CREATE TABLE users
(
    id       int UNSIGNED NOT NULL AUTO_INCREMENT,
    name     varchar(64)  NOT NULL,
    password varchar(128) NOT NULL,
    email    varchar(64)  NULL DEFAULT NULL,
    PRIMARY KEY (id, name)
);

CREATE TABLE vip
(
    id          int UNSIGNED   NOT NULL AUTO_INCREMENT,
    vipno       varchar(32)    NOT NULL,
    vipname     varchar(64)    NOT NULL,
    vipbalance  decimal(16, 2) NOT NULL,
    vippassword varchar(128)   NULL DEFAULT NULL,
    vipresdate  date           NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE warehouse
(
    whno     varchar(12) NOT NULL,
    whname   varchar(10) NOT NULL,
    whadress varchar(20) NOT NULL,
    PRIMARY KEY (whno)
);

