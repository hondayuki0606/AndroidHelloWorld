#!/bin/bash


# 初期設定

# バージョン情報をファイル名から取得する
FILENAME=$@
LEN=`echo $((${#FILENAME} - 4))`
FOLDER=`echo ${FILENAME} | cut -c 1-${LEN}`

# バージョン情報をファイル名から取得する
NUMVALUES=`echo ${FOLDER} | sed -e 's/[^0-9]//g'`
VERSION=`echo ${NUMVALUES} | sed -e 's/\(.\)/\1./g'`
LEN=`echo $((${#VERSION} - 1))`
VERSION=`echo ${VERSION} | cut -c 1-${LEN}`

GROUPID=harmansdk

# 生成するフォルダが存在する場合は削除
if [ -d __MACOSX ];then
  rm -rf __MACOSX
fi

if [ -d ${FOLDER} ];then
  rm -rf ${FOLDER}
fi

# 圧縮ファイルを解凍する
unzip ${FILENAME}

# 不要なフォルダが存在する場合は削除
if [ -d __MACOSX ];then
  rm -rf __MACOSX
fi

# 出力先のパスを作成する
cd ${FOLDER}
mkdir ${GROUPID}
echo "output directory ${GROUPID} to /${GROUPID}"

# 解凍したファイル内のjarファイルを全てコピーする
for file in `find . -name '*.jar'`; do
  echo "copy ${file} to /${GROUPID}"
  cp $file ${GROUPID}
done

# 出力先のディレクトリに移動する
cd ${OUTPUTDIR}

# 出力先のjarファイル文、繰り返し処理を行う
for file in $( ls . | grep .jar$ ); do

    # ファイル拡張子の.jarを除去
    FILENAME=${file}
    LEN=`echo $((${#file} - 4))`
    ARCHITECT=`echo ${FILENAME} | cut -c 1-${LEN}`
   
    # ARCHITECTのフォルダ作成
    mkdir ${ARCHITECT}
    cd ${ARCHITECT}
    
    # VERSIONのフォルダ作成
    mkdir ${VERSION}
    cd ${VERSION}
    
    echo "touch ${ARCHITECT}-${VERSION}.pom to /${OUTPUTDIR}"
    
    # ファイル生成と書き込み処理を実施
    touch ${ARCHITECT}-${VERSION}.pom
    echo '<'project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"'>' >> ${ARCHITECT}-${VERSION}.pom
    echo '    <'modelVersion'>'${VERSION}'<'/modelVersion'>' >> ${ARCHITECT}-${VERSION}.pom
    echo '    <'groupId'>'${GROUPID}'<'/groupId'>' >> ${ARCHITECT}-${VERSION}.pom
    echo '    <'artifactId'>'${ARCHITECT}'<'/artifactId'>' >> ${ARCHITECT}-${VERSION}.pom
    echo '    <'version'>'${VERSION}'<'/version'>' >> ${ARCHITECT}-${VERSION}.pom
    echo '    <'name'>'${ARCHITECT}'<'/name'>' >> ${ARCHITECT}-${VERSION}.pom
    
    cd ..'/'..

    # Jarファイルの名前を変更する
    mv ${FILENAME} ${ARCHITECT}/${VERSION}/${FOLDER}-${VERSION}.jar

done

