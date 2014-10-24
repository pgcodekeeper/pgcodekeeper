#!/bin/bash
# This script is used to run gitchangelog in git repository, to collect commit data from them
#------------------------------------------------------------------------------------------
# Install some python on Ubuntu
# sudo apt-get install python-pip python-dev build-essential
# pip install gitchangelog
#------------------------------------------------------------------------------------------

# Repository may have .gitchangelog.rc file to customize it's commits to collect
repositoryList=("ru.taximaxim.codekeeper.mainapp" "apgdiff" "ru.taximaxim.codekeeper.ui");
# folder for changelogs
change_log_folder="/changelogs"
# Get path to script
ROOT_PATH=$(cd $(dirname $0) && pwd);
# Create directory for changelogs
if ! [ -d ${ROOT_PATH}${change_log_folder} ]; then
 mkdir ${ROOT_PATH}${change_log_folder};
fi
# changelog util
TOOLS_GEN_CHANGE_LOG="gitchangelog"
# changelog filename
CHANGE_LOG_FILENAME="changelog.txt";
# Command to get changelog
COMMAND=${TOOLS_GEN_CHANGE_LOG}" > "${CHANGE_LOG_FILENAME};
# Set path to changeLogSettings
export GITCHANGELOG_CONFIG_FILENAME=${ROOT_PATH}"/.gitchangelog.rc";
#-----------------------------------------------
version=$(${TOOLS_GEN_CHANGE_LOG} | egrep -m 1 -i -o 'Версия .\..\..')
# Write Version to file
echo $version" has been released." > ${ROOT_PATH}${change_log_folder}"/"${CHANGE_LOG_FILENAME}
# Combine changes to separate files: reponame.txt
for ((i=0;i<${#repositoryList[@]};i++));do 
	PATH_TO_REPO=${ROOT_PATH}"/../"${repositoryList[$i]};
	cd $PATH_TO_REPO;
	eval $COMMAND;
	cat ${CHANGE_LOG_FILENAME} > ${ROOT_PATH}${change_log_folder}"/"${repositoryList[$i]}".txt"
	rm -rf ${CHANGE_LOG_FILENAME}
done
