#!/bin/bash
# This script is used to run gitchangelog in git repository, to collect commit data from them
#------------------------------------------------------------------------------------------
# Install some python on Ubuntu
# sudo apt-get install python-pip python-dev build-essential
# pip install gitchangelog
# WARNING!!!!!
# gitchangelog.py uses "git log with --first-parent" which doesn't show all commits in the repository
# need some modification in 261,453 strings, file "/usr/local/lib/python2.7/dist-packages/gitchangelog.py" 
#------------------------------------------------------------------------------------------

# Repository may have .gitchangelog.rc file to customize it's commits to collect
repositoryList=("codekeeper");
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
version=$(${TOOLS_GEN_CHANGE_LOG} | egrep -m 1 -i -o 'v.\..\..')
# Write Version to file
echo $version" has been released." > ${ROOT_PATH}${change_log_folder}"/"${CHANGE_LOG_FILENAME}
# Combine changes to separate files: reponame.txt
for ((i=0;i<${#repositoryList[@]};i++));do 
	PATH_TO_REPO=${ROOT_PATH}"/../../"${repositoryList[$i]};
	cd $PATH_TO_REPO;
	# get revereted repolist git_tag_rev
	declare -a git_tags
	git_tags=($(git tag))
	declare -a git_tag_rev
	declare -i ind_rev
	ind_rev=0
	for ((ind=${#git_tags[@]} - 1; ind >= 0; ind --)); do
		git_tag_rev[ind_rev]=${git_tags[$ind]}
		ind_rev=$(expr $ind_rev + 1)
	done
	# -------------------------------
	# get last and pre last tag name 
	last_tag=${git_tag_rev[0]}
	pre_last_tag=${git_tag_rev[1]} 
	# get file with commits separated by tag
	eval $COMMAND;
	# find numbers tags
	last_tag_number=$(cat ${CHANGE_LOG_FILENAME} | awk "/$last_tag/{ print NR; exit }")
	pre_last_tag_number=$(cat ${CHANGE_LOG_FILENAME} | awk "/$pre_last_tag/{ print NR; exit }")
	# set numbers to right values to use with head tail commands
	pre_last_tag_number=$(expr $pre_last_tag_number - 1)
	last_tag_number=$(expr $pre_last_tag_number - $last_tag_number)
	#echo "$pre_last_tag_number $last_tag_number"
	#cat ${CHANGE_LOG_FILENAME} | head -n $pre_last_tag_number | tail -n $last_tag_number
	# write repo name to file
	echo ${repositoryList[$i]} >> ${ROOT_PATH}${change_log_folder}"/"${CHANGE_LOG_FILENAME}
	# write commits to file
	cat ${CHANGE_LOG_FILENAME} | head -n $pre_last_tag_number | tail -n $last_tag_number >> ${ROOT_PATH}${change_log_folder}"/"${CHANGE_LOG_FILENAME}
	# write all commits to separate file
	cat ${CHANGE_LOG_FILENAME} > ${ROOT_PATH}${change_log_folder}"/"${repositoryList[$i]}".txt"
	# remove commits file from repository
	rm -rf ${CHANGE_LOG_FILENAME}
done
