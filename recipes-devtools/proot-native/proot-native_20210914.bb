SUMMARY = "chroot, mount --bind, and binfmt_misc without privilege/setup for Linux"
DESCRIPTION = "PRoot is a user-space implementation of chroot, mount --bind, and binfmt_misc.\
               This means that users don't need any privileges or setup to do things like using \
               an arbitrary directory as the new root filesystem, making files accessible somewhere \
               else in the filesystem hierarchy, or executing programs built for another CPU \
               architecture transparently through QEMU user-mode"
HOMEPAGE = "https://github.com/proot-me/proot"
LICENSE = "GPL-2.0"

LIC_FILES_CHKSUM = "file://../COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += "\
    libarchive-native \
    libtalloc-native \
"

SRC_URI = "git://github.com/proot-me/proot.git;protocol=https"
SRCREV = "4de38a7709a64c940331de0f0ea2eede6001b7f5"

S = "${WORKDIR}/git/src"

UPSTREAM_CHECK_COMMITS = "1"

inherit pkgconfig
inherit native

do_compile() {
    oe_runmake PREFIX=${prefix} BINDIR=${bindir}
}

do_install() {
    oe_runmake install DESTDIR=${D} PREFIX=$prefix BINDIR=${bindir}
}
