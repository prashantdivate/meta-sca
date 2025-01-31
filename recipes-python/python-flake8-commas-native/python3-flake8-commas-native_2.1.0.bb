SUMMARY = "Flake8 lint for trailing commas"
HOMEPAGE = "https://github.com/PyCQA/flake8-commas/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c816149279ec41ec9d1cba44cbd47b03"

DEPENDS += "python3-flake8-native"

SRC_URI = "git://github.com/PyCQA/flake8-commas.git;protocol=https"
SRCREV = "f19499b91d8408abd47b3fc070fa230f53c0c8ac"
S = "${WORKDIR}/git"

inherit setuptools3
inherit native
