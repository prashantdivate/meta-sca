SUMMARY = "go.mod: cloud.google.com/go/datastore"
HOMEPAGE = "https://pkg.go.dev/cloud.google.com/go/datastore"

# License is determined by the modules included and will be therefore computed
LICENSE = "${@' & '.join(sorted(set(x for x in (d.getVar('GOSRC_LICENSE') or '').split(' ') if x)))}"

# inject the needed sources
require cloud.google.com-go-datastore-sources.inc

EXTRA_DEPENDS += "\
    cloud.google.com-go-native \
    github.com-golang-protobuf-native \
    github.com-googleapis-gax-go-v2-native \
    google.golang.org-api-native \
    google.golang.org-genproto-native \
    google.golang.org-grpc-native \
    google.golang.org-protobuf-native \
"

GO_IMPORT = "cloud.google.com/go/datastore"

inherit gosrc
inherit native
