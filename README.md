# meta-sca

## Purpose

This layer does offer some static code analysis tools, which can be easily configured and integrated into YOCTO/Open-Embedded build system.
The layer is designed to be easy to integrate (and fully configurable).
All results are stored to __SCA_EXPORT_DIR__ (which defaults to __${DEPLOY_DIR_IMAGE}/sca__). The results will be stored in the raw-format of the corresponding tool and in checkstyle-format.
Any result-file can be easily integrated into e.g. Jenkins or other CI-tools

### Licensing

This layer does only provide open source tools.
The layer itself is licensed under BSD.

### Zero impact

This layer provides only **-native** tools, so actually none of the build binaries will be deployed to your target.
Everything happens on the build machine.

## Prerequisites

You need the current standard __poky__-layer installed onto your local build environment

## Installation
In your __bblayers.conf__-file add the following line 
``` shell
BBLAYERS += "<full path to sca-layer>/meta-sca"
```

## Available tools

The layer can check on a recipe-level or on an image-level.
On image-level the whole root-filesystem could be taken into account, which in most cases can't be granted on a recipe-level.
On the other hand some static code analysis does not make any sense on an image-level - so this layer does have different tools for both level available. In square brackets the corresponding setting in this layer is given

### Tools for image recipes

 * ansible (security) [ansible]
 * [ansible-lint](https://github.com/ansible/ansible-lint) (ansible) [ansiblelint]
 * [bandit](https://github.com/PyCQA/bandit) (python/security) [bandit]
 * [bashate](http://docs.openstack.org/developer/bashate/) (shell) [bashate]
 * [checkbashisms](https://manpages.debian.org/jessie/devscripts/checkbashisms.1.en.html) (shell) [checkbashism]
 * bitbake (handle bitbake issues) [bitbake]
 * [detect-secrets](https://github.com/Yelp/detect-secrets) (detecting and preventing secrets in code) [detectsecrets]
 * [eslint](https://github.com/eslint/eslint) (javascript/html) [eslint]
 * [gixy](https://github.com/yandex/gixy) (nginx-config security) [gixy]
 * [htmlhint](https://github.com/htmlhint/HTMLHint) (html) [htmlhint]
 * image-summary (aggregate all findings for package in an image) [image-summary]
 * json-parser (json) [jsonlint]
 * [oelint-adv](https://github.com/priv-kweihmann/oelint-adv) (linting bitbake recipes) [oelint]
 * [proselint](https://github.com/amperser/proselint/) (spelling) [proselint]
 * [py-find-injection](https://github.com/uber/py-find-injection) (find SQL injections in python) [pyfindinjection]
 * [pylint](https://github.com/PyCQA/pylint) (python) [pylint]
 * [shellcheck](https://github.com/koalaman/shellcheck) (shell) [shellcheck]
 * [standard](https://github.com/standard/standard) (javascript) [standard]
 * [stylelint](https://github.com/stylelint/stylelint) (css, scss) [stylelint]
 * [systemdlint](https://github.com/priv-kweihmann/systemdlint) (systemd) [systemdlint]
 * [tlv](https://github.com/priv-kweihmann/tlv) (duplicate code) [tlv]
 * [xmllint](http://xmlsoft.org/xmllint.html) (xml) [xmllint]
 * [yamllint](https://github.com/adrienverge/yamllint) (yaml) [yamllint]

### Tools for all other recipes

 * [ansible-lint](https://github.com/ansible/ansible-lint) (ansible) [ansiblelint]
 * [bandit](https://github.com/PyCQA/bandit) (python/security) [bandit]
 * [bashate](http://docs.openstack.org/developer/bashate/) (shell) [bashate]
 * bitbake (handle bitbake issues) [bitbake]
 * [checkbashisms](https://manpages.debian.org/jessie/devscripts/checkbashisms.1.en.html) (shell) [checkbashism]
 * [clang-tidy](https://clang.llvm.org/extra/clang-tidy/) (c/c++) [clang]
 * [cppcheck](https://github.com/danmar/cppcheck) (c/c++) [cppcheck]
 * [cpplint](https://github.com/cpplint/cpplint) (c/c++) [cpplint]
 * [cqmetrics](https://github.com/dspinellis/cqmetrics) (metrics for c/c++) [cqmetrics]
 * [cspell](https://github.com/Jason3S/cspell) (spelling in c/c++/html/python/txt/md) [cspell]
 * [cve-check](https://github.com/clearlinux/cve-check-tool) (check for unpatched cve's) [cvecheck]
 * [dennis](https://github.com/willkg/dennis/) (i18n) [dennis]
 * [detect-secrets](https://github.com/Yelp/detect-secrets) (detecting and preventing secrets in code) [detectsecrets]
 * [eslint](https://github.com/eslint/eslint) (javascript/html) [eslint]
 * [flint++](https://github.com/JossWhittle/FlintPlusPlus) (c/c++) [flint]
 * gcc (getting compiler warnings/errors) [gcc]
 * [htmlhint](https://github.com/htmlhint/HTMLHint) (html) [htmlhint]
 * json-parser (json) [jsonlint]
 * [kconfig-hardened-check](https://github.com/a13xp0p0v/kconfig-hardened-check) (check hardening of kernel) [kconfighard]
 * [oclint](https://github.com/oclint/oclint) (c/c++/obj-c) [oclint]
 * [oelint-adv](https://github.com/priv-kweihmann/oelint-adv) (linting bitbake recipes) [oelint]
 * [py-find-injection](https://github.com/uber/py-find-injection) (find SQL injections in python) [pyfindinjection]
 * [proselint](https://github.com/amperser/proselint/) (spelling) [proselint]
 * [pylint](https://github.com/PyCQA/pylint) (python) [pylint]
 * [pysymbolcheck](https://github.com/priv-kweihmann/pysymbolcheck) (check elf-files for used functions) [pysymcheck]
 * [pytype](https://github.com/google/pytype) (python) [pytype]
 * [radon](https://github.com/rubik/radon) (metrics for python) [radon]
 * [rats](https://github.com/redNixon/rats) (security for c/php/python/perl/ruby) [rats]
 * [ropgadget](https://github.com/JonathanSalwan/ROPgadget) (determine exploitability with ROP in binary) [ropgadget]
 * score (calculate a score for a module, like pylint does) [score]
 * [shellcheck](https://github.com/koalaman/shellcheck) (shell) [shellcheck]
 * [standard](https://github.com/standard/standard) (javascript) [standard]
 * [stylelint](https://github.com/stylelint/stylelint) (css, scss) [stylelint]
 * [textlint](https://github.com/textlint/textlint) (spelling) [textlint]
 * [tlv](https://github.com/priv-kweihmann/tlv) (duplicate code) [tlv]
 * [tscancode](https://github.com/Tencent/TscanCode) (c,c#,lua) [tscancode]
 * [xmllint](http://xmlsoft.org/xmllint.html) [xmllint]
 * [yamllint](https://github.com/adrienverge/yamllint) (yaml) [yamllint]
 * [zeroresourcedetector](https://github.com/0Cubed/ZeroResourceDetector) (g18n/i18n) [zrd]

each tool does have it's own benefits and flaws so don't be mad if you have 10k+ findings on the initial run.

# Optional requirements

To make the integration of clang-module (clang-tidy) work you need to add the [meta-clang](https://github.com/kraj/meta-clang) layer to your bblayer-file. If not present the clang integration will be silently disabled

# Configuration

There are several ways to integrate static code analysis into your code base.

## Configuration wizard

You can find a configuration wizard script at 

``` shell
<layer-root>/script/configure
```

Just execute it and copy the stated result into either your local.conf or your distribution-config.
**NOTE**: the script requires __python3__ to be installed on your system.

## Use on all recipes in your workspace

Edit the file conf/__local.conf__ and add the following line
```shell
INHERIT += "sca"
```
this will run static code analysis on __all__ the recipes available and used in your workspace.
It might be a good idea to do this if you like to wait for a very long time on your build - maybe nightly builds or similar

## Use on particular recipes in your workspace

Edit the recipe-file by adding the following line
```bitbake
inherit sca
```
Now the power of static code analysis will be applied to exactly this image

## Available configuration variables

The behavior of the analysis can be controlled by several __bitbake__-variables

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:|
| SCA_AUTO_INH_ON_IMAGE | Do automatically enable analysis on image-recipes | string | "1"
| SCA_AUTO_INH_ON_RECIPE | Do automatically enable analysis on other recipes | string | "1"
| SCA_AUTO_LICENSE_FILTER | Filter according to recipe license if sca should invoked | space separated regular expression | ".*"
| SCA_AVAILABLE_MODULES | List of all available modules, use to globally enable/disable modules | space-separated-string | all available modules
| SCA_ENABLE | Does globally enable the analysis | string | "1"
| SCA_ENABLE_BESTOF | Enables/disables the BestOf mode (see chapter BestOf Mode) | string | "0"
| SCA_ENABLE_IMAGE_SUMMARY | En/disable the image-summary module | string | "1"
| SCA_ENABLE_SCORE | En/disable the module score (see __score__ for details) | string | "1"
| SCA_ENABLED_MODULES | The analysis modules to be activated | space-separated-string | see sca-on-image.bbclass or sca-on-recipe.bbclass
| SCA_EXPORT_DIR | Directory where to store the results of analysis | path | \${DEPLOY_DIR_IMAGE}/sca
| SCA_EXPORT_FINDING_DIR | The folder where to store the original source-files of findings | path | \${DEPLOY_DIR_IMAGE}/sca/sources/\${PN}/
| SCA_EXPORT_FINDING_SRC | Do copy the source-files of any finding to deploy-dir. This proved to helpful when integrating into Jenkins. | string | "1"
| SCA_FILE_FILTER | List of glob-expression of file to skip for testing | space separated list | "tests/* test/* doc/* testsuite/* \*\*/tests/* \*\*/test/* \*\*/doc/* \*\*/testsuite/*"
| SCA_SOURCES_DIR | Path where to find the source-files to be checked | path | "\${B}" for recipes, "\${IMAGE_ROOTFS}" for images
| SCA_STD_PYTHON_INTERPRETER | Standard python interpreter to be used in SCA | python or python3 | "python3"
| SCA_WARNING_LEVEL | Filter for severity of findings | string: info, warning or error | "warning"

You can also exclude recipe from all or certain tools therefore a blacklisting configuration exists.
To exclude __all__ tools from a recipe use the following variable

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:|
| SCA_BLACKLIST | regular expression(s) | space separated list | ".*-native"

The effective configuration is a merge of the global blacklist and the tool specific blacklist

Also you can skip testing certain files. You can set this globally by appending to **SCA_FILE_FILTER** or on a recipe level 
by defining a variable called **SCA_FILE_FILTER_EXTRA**.

### Available configuration for ansible

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_ansible | Blacklist filter for this tool | space-separated-list | ""
| SCA_ANSIBLE_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_ANSIBLE_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_ANSIBLE_PLAYBOOKS | List of glob-expr to search for playbooks | space-separated-list | "*.yaml"

**Note**: __A detailed description of how things are working regarding ansible and playbooks will follow soon__

### Available configuration for ansiblelint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_ansiblelint | Blacklist filter for this tool | space-separated-list | ""
| SCA_ANSIBLELINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_ANSIBLELINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_ANSIBLELINT_FILE_FILTER | List of file extensions to search for playbooks | space-separated-list | ".yaml"

### Available configuration for bandit

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BANDIT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_BANDIT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_BLACKLIST_bandit | Blacklist filter for this tool | space-separated-list | "linux-*"

### Available configuration for bashate

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BASHATE_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_BASHATE_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_BLACKLIST_bashate | Blacklist filter for this tool | space-separated-list | ""

### Available configuration for bitbake

__NOTE:__ this tool does not support suppression or fatal error handling

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_bitbake | Blacklist filter for this tool | space-separated-list | ""

### Available configuration for checkbashism

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_checkbashism | Blacklist filter for this tool | space-separated-list | ""
| SCA_CHECKBASHISM_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_CHECKBASHISM_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for clang

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_clang | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_CLANG_ADD_INCLUDES | List of additional include paths | space-separated-list | ""
| SCA_CLANG_CHECKERS | List of clang-tidy checkers to execute | space-separated-list | see sca-clang.bbclass for details
| SCA_CLANG_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_CLANG_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_CLANG_FILE_FILTER | List of file extensions to check | space-separated-list | ".c .cpp"

### Available configuration for cppcheck

For further explanations on the variables see the manpage of cppcheck

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_cppcheck | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_CPPCHECK_ADD_INCLUDES | Additional paths leading to includes | space-separated-list | ""
| SCA_CPPCHECK_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_CPPCHECK_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_CPPCHECK_FILE_FILTER | List of file-extensions to be checked | space-separated-list | ".c .cpp .h .hpp"
| SCA_CPPCHECK_LANG_STD | C standard to check on | space separated list | "c99"
| SCA_CPPCHECK_CHECK_DEPTH | Depth of analysis - higher value = higher effort | int | "3"

### Available configuration for cpplint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_cpplint | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_CPPLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_CPPLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_CPPLINT_FILE_FILTER | List of file-extensions to be checked | space-separated-list | ".c .cpp .h .hpp"

### Available configuration for cqmetrics

Within this module you can define metrics on any C/C++ source code.
This module offers the possibility to issue a warning or an error if a configured threshold is exceeded.

To configure a threshold define a variable

**SCA_CQMETRICS_WARN_\<ID\>_gt** - for a warning when the value if greater than the threshold
**SCA_CQMETRICS_WARN_\<ID\>_lt** - for a warning when the value if less than the threshold
**SCA_CQMETRICS_ERROR_\<ID\>_gt** - for a warning when the value if greater than the threshold
**SCA_CQMETRICS_ERROR_\<ID\>_lt** - for a warning when the value if less than the threshold

All values are floating point units (as string).

Possible IDs are

 * nchar - Number of characters
 * nline - Number of lines
 * line_length_min - Line length minimum
 * line_length_mean - Line length mean
 * line_length_median - Line length median
 * line_length_max - Line length maximum
 * line_length_sd - Line length standard deviation
 * nempty_line - Number of empty lines
 * nstatement - Number of statements
 * statement_nesting_min - Nested statements minimum
 * statement_nesting_mean - Nested statements mean
 * statement_nesting_median  - Nested statements median
 * statement_nesting_max  - Nested statements maximum
 * statement_nesting_sd  - Nested statements standard deviation
 * ninternal - Number of declarations with internal linkage static visibility
 * nconst - Number of const keywords
 * nenum - Number of enum keywords
 * ngoto - Number of goto statements
 * ninline - Number of inline keywords
 * nnoalias - Number of noalias keywords
 * nregister - Number of register keywords
 * nrestrict - Number of restrict keywords
 * nsigned - Number of signed keywords
 * nstruct - Number of struct keywords
 * nunion - Number of union keywords
 * nunsigned - Number of unsigned keywords
 * nvoid - Number of void keywords
 * nvolatile - Number of volatile keywords
 * ntypedef - Number of typedef keywords
 * ncomment - Number of comments
 * ncomment_char - Number of comment characters
 * nboilerplate_comment_char - Number of boilerplate/license comment characters
 * ndox_comment - Number of DOxygen comments
 * ndox_comment_char - Number of DOxygen comment characters
 * nfun_comment - Number of comments inside function bodies
 * ncpp_directive - Number of C preprocessor directives
 * ncpp_include - Number of C preprocessor include directives
 * ncpp_conditional - Number of C preprocessor conditional directives #if, #ifdef, #elif
 * nfun_cpp_directive - Number of C preprocessor directives in function bodies
 * nfun_cpp_conditional - Number of C preprocessor conditional directives in function bodies
 * style_inconsistency - Style inconsistency
 * nfunction - Number of functions Halstead complexity
 * halstead_min - Halstead complexity per function minumum
 * halstead_mean - Halstead complexity per function mean
 * halstead_median - Halstead complexity per function median
 * halstead_max - Halstead complexity per function maximum
 * halstead_sd - Halstead complexity per function standard
 * nfunction2 - Number of functions cyclomatic complexity
 * cyclomatic_min - Cyclomatic complexity minimum
 * cyclomatic_mean - Cyclomatic complexity mean
 * cyclomatic_median - Cyclomatic complexity median
 * cyclomatic_max - Cyclomatic complexity maximum
 * cyclomatic_sd - Cyclomatic complexity standard deviation
 * nidentifier - Identifier length
 * identifier_length_min - Identifier length minimum
 * identifier_length_mean - Identifier length mean
 * identifier_length_median - Identifier length median
 * identifier_length_max - Identifier length maximum
 * identifier_length_sd - Identifier length standard deviation
 * unique_nidentifier - Unique identifier length
 * unique_identifier_length_min - Unique identifier length minimum
 * unique_identifier_length_mean - Unique identifier length mean
 * unique_identifier_length_median - Unique identifier length median
 * unique_identifier_length_max - Unique identifier length maximum
 * unique_identifier_length_sd - Unique identifier length standard deviation
 * indentation_spacing_count - Spaces used for one level of indentation
 * indentation_spacing_min - Spaces used for one level of indentation minimum
 * indentation_spacing_mean - Spaces used for one level of indentation mean
 * indentation_spacing_median - Spaces used for one level of indentation median
 * indentation_spacing_max - Spaces used for one level of indentation maximum
 * indentation_spacing_sd - Spaces used for one level of indentation standard deviation
 * nno_space_after_binary_op - Number of occurences of no space after binary operator
 * nno_space_after_closing_brace - Number of occurences of no space after closing brace
 * nno_space_after_comma - Number of occurences of no space after comma
 * nno_space_after_keyword - Number of occurences of no space after keyword
 * nno_space_after_opening_brace - Number of occurences of no space after opening brace
 * nno_space_after_semicolon - Number of occurences of no space after semicolon
 * nno_space_before_binary_op - Number of occurences of no space before binary operator
 * nno_space_before_closing_brace - Number of occurences of no space before closing brace
 * nno_space_before_keyword - Number of occurences of no space before keyword
 * nno_space_before_opening_brace - Number of occurences of no space before opening brace
 * nspace_after_opening_square_bracket - Number of occurences of space after opening square bracket
 * nspace_after_struct_op - Number of occurences of space after struct operator
 * nspace_after_unary_op - Number of occurences of space after unary operator
 * nspace_at_end_of_line - Number of occurences of space at end of line
 * nspace_before_closing_bracket - Number of occurences of space before closing bracket
 * nspace_before_closing_square_bracket - Number of occurences of space before closing square bracket
 * nspace_before_comma - Number of occurences of space before comma
 * nspace_before_opening_square_bracket - Number of occurences of space before opening square bracket
 * nspace_before_semicolon - Number of occurences of space before semicolon
 * nspace_before_struct_op - Number of occurences of space before struct operator
 * nspace_after_binary_op - Number of occurences of space after binary operator
 * nspace_after_closing_brace - Number of occurences of space after closing brace
 * nspace_after_comma - Number of occurences of space after comma
 * nspace_after_keyword - Number of occurences of space after keyword
 * nspace_after_opening_brace - Number of occurences of space after opening brace
 * nspace_after_semicolon - Number of occurences of space after semicolon
 * nno_space_after_struct_op - Number of occurences of no space after struct operator
 * nspace_before_binary_op - Number of occurences of space before binary operator
 * nspace_before_closing_brace - Number of occurences of space before closing brace
 * nspace_before_keyword - Number of occurences of space before keyword
 * nspace_before_opening_brace - Number of occurences of space before opening brace
 * nno_space_before_struct_op - Number of occurences of no space before struct operator
 * nno_space_after_opening_square_bracket - Number of occurences of no space after opening square bracket
 * nno_space_after_unary_op - Number of occurences of no space after unary operator
 * nno_space_before_closing_bracket - Number of occurences of no space before closing bracket
 * nno_space_before_closing_square_bracket - Number of occurences of no space before closing square bracket
 * nno_space_before_comma - Number of occurences of no space before comma
 * nno_space_before_opening_square_bracket - Number of occurences of no space before opening square bracket
 * nno_space_before_semicolon - Number of occurences of no space before semicolon

Furthermore the following variables are defined for this module

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_cqmetrics | Blacklist filter for this tool | space-separated-list | ""
| SCA_CQMETRICS_ERROR_cyclomatic_max_gt | Threshold for maximum cyclomatic complexity before issuing an error | float-string | "30.0"
| SCA_CQMETRICS_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_CQMETRICS_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_CQMETRICS_FILE_FILTER | List of file-extensions to be checked | space-separated-list | ".c .cpp .h .hpp"
| SCA_CQMETRICS_WARN_cyclomatic_max_gt | Threshold for maximum cyclomatic complexity before issuing a warning | float-string | "15.0"

### Available configuration for cspell

This module is someway different in configuration than the other.
First of all this module does not support suppression or fatal-errors, as the only error this module 
produces is to warn you about typos and unknown words.
The check itself is done for each configured language - meaning a defined set of dictionaries is used for checking.
Currently available as dictionaries are

| name | purpose | enable default 
| ------------- | -----:| -----:
| companies | Known companies list | yes
| cpp | C/C++ terms and functions | no
| csharp | C# terms and functions | no
| css | CSS terms | no
| django | Django terms | no
| dotnet | .Net terms | no
| elixir | Elixir terms | no
| en_US | standard us-English dict | yes
| filetypes | List of known filetypes | yes
| fonts | List of known fonts | yes
| fullstack | Different terms from software development | yes
| go | Go-Lang terms | no
| html | HTML terms | no
| java | JAVA terms | no
| misc | Term often used | yes
| node | Node.js terms | no
| npm | NPM terms | no
| php | PHP terms | no
| powershell | Powershell terms | no
| python | Python terms | no
| rust | Rust terms | no
| scala | Scala terms | no
| softwareTerms | More terms from software development | yes
| typescript | Typescript terms | no

These dictionaries are applied to language by defining the following case sensitive variables

 * **SCA_CSPELL_LANG_\<LANG_CODE\>_files** - List of file extensions to check
 * **SCA_CSPELL_LANG_\<LANG_CODE\>_dicts** - List of dictionaries to add the default selection for checking
 * **SCA_CSPELL_LANG_\<LANG_CODE\>_shebang** - Regex for getting file by shebang

Following variables are therefore languages are exposed by default

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_cspell | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_CSPELL_CHECK_LANG | List of languages configured | space-separated-list | "CPP HTML PYTHON TXT"
| SCA_CSPELL_LANG_CPP_dicts | Dictionaries for CPP | space-separated-list | "cpp"
| SCA_CSPELL_LANG_CPP_files | Files to check for CPP | space-separated-list | ".c .cpp .h .hpp"
| SCA_CSPELL_LANG_HTML_dicts | Dictionaries for HTML | space-separated-list | "html css typescript"
| SCA_CSPELL_LANG_HTML_files | Files to check for HTML | space-separated-list | ".html .htm .js"
| SCA_CSPELL_LANG_PYTHON_dicts | Dictionaries for PYTHON | space-separated-list | "python"
| SCA_CSPELL_LANG_PYTHON_files | Files to check for PYTHON | space-separated-list | ".py"
| SCA_CSPELL_LANG_PYTHON_shebang | Files to check for PYTHON | space-separated-list | ".*python"
| SCA_CSPELL_LANG_TXT_dicts | Dictionaries for TXT | space-separated-list | ""
| SCA_CSPELL_LANG_TXT_files | Files to check for TXT | space-separated-list | ".txt .md .rst"

__NOTE__: By the default this module does only generate warnings of level **"info"**. 
So if you like them to be deployed you have to set **SCA_WARNING_LEVEL** to __"info"__ globally or in the 
recipe.

### Available configuration for cvecheck

__NOTE:__ this tool does not support suppression or fatal error handling

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_cvecheck | Blacklist filter for this tool | space-separated-list | ""

### Available configuration for dennis

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_dennis | Blacklist filter for this tool | space-separated-list | ""
| SCA_DENNIS_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | "":
| SCA_DENNIS_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for detectsecrets

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_detectsecrets | Blacklist filter for this tool | space-separated-list | ""
| SCA_DETECTSECRETS_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | "":
| SCA_DETECTSECRETS_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for eslint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_eslint | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_ESLINT_CONFIG_FILE | Configuration-file to be used. See recipe eslint-native for details | string: eslint-standard.json, eslint-plain.json, eslint-airbnb.json, eslint-google.json | eslint-plain.json
| SCA_ESLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | "":
| SCA_ESLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for flint++

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_flint | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_FLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_FLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_FLINT_FILE_FILTER | List of file-extensions to be checked | space-separated-list | ".c .cpp .h .hpp"

### Available configuration for gcc

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_gcc | Blacklist filter for this tool | space-separated-list | ""
| SCA_GCC_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_GCC_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for gixy

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_gixy | Blacklist filter for this tool | space-separated-list | ""
| SCA_GIXY_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_GIXY_FILE_FILTER | List of file-extensions to be checked | space-separated-list | ".json"
| SCA_GIXY_NGINX_CONF | NGINX config file to be checked | string | "/etc/nginx/nginx.conf"

### Available configuration for htmlhint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_htmlhint | Blacklist filter for this tool | space-separated-list | ""
| SCA_HTMLHINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_HTMLHINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for jsonlint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_jsonlint | Blacklist filter for this tool | space-separated-list | ""
| SCA_JSONLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_JSONLINT_FILE_FILTER | List of file-extensions to be checked | space-separated-list | ".json"

### Available configuration for kconfighard

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_kconfighard | Blacklist filter for this tool | space-separated-list | ""
| SCA_KCONFIGHARD_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_KCONFIGHARD_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for oclint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_oclint | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_OCLINT_ADD_INCLUDES | List of additional include paths | space-separated-list | ""
| SCA_OCLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_OCLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_OCLINT_FILE_FILTER | List of file extensions to check | space-separated-list | ".c .cpp"

### Available configuration for oelint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_oelint | Blacklist filter for this tool | space-separated-list | ""
| SCA_OELINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_OELINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for proselint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_proselint | Blacklist filter for this tool | space-separated-list | ""
| SCA_PROSELINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_PROSELINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_PROSELINT_FILE_FILTER | List of file extensions to check | space-separated-list | ".txt .md .rst .me"

### Available configuration for pyfindinjection

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_pyfindinjection | Blacklist filter for this tool | space-separated-list | ""
| SCA_PYFINDINJECTION_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_PYFINDINJECTION_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for pylint (image)

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_pylint | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_PYLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_PYLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_PYLINT_HOMEPATH | Directory of python installation | path | \${IMAGE_ROOTFS}/python.3.5
| SCA_PYLINT_LIBATH | List of library paths for python | ':' separated list | \${IMAGE_ROOTFS}/python.3.5/:\${IMAGE_ROOTFS}/python.3.5/site-packages/
| SCA_PYLINT_ROOTPATH | Root path from where checks should be performed | path | \${IMAGE_ROOTFS}

### Available configuration for pylint (recipe)

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_pylint | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_PYLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_PYLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_PYLINT_HOMEPATH | Directory of python installation | path | \${STAGING_LIBDIR}/python.3.5
| SCA_PYLINT_LIBATH | List of library paths for python | ':' separated list | \${STAGING_LIBDIR}/python.3.5/:\${STAGING_LIBDIR}/python.3.5/site-packages/
| SCA_PYLINT_ROOTPATH | Root path from where checks should be performed | path | \${B}

### Available configuration for pysymcheck

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_pysymcheck | Blacklist filter for this tool | space-separated-list | ""
| SCA_PYSYMCHECK_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_PYSYMCHECK_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_PYSYMCHECK_RULE_FILE | Configuration-file to be used. Must be installed to \<root\>/usr/bin/pysymbolcheck/ | string: basic_rules.json | "basic_rules.json"

### Available configuration for pytype

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_pytype | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_PYTYPE_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_PYTYPE_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for radon

Within this module you can define metrics on any python source code.
This module offers the possibility to issue a warning or an error if a configured threshold is exceeded.

To configure a threshold define a variable

**SCA_RADON_WARN_\<ID\>_gt** - for a warning when the value if greater than the threshold
**SCA_RADON_WARN_\<ID\>_lt** - for a warning when the value if less than the threshold
**SCA_RADON_ERROR_\<ID\>_gt** - for a warning when the value if greater than the threshold
**SCA_RADON_ERROR_\<ID\>_lt** - for a warning when the value if less than the threshold

All values are floating point units (as string).

Possible IDs are

 * blank_lines_max - Lines with no content max
 * blank_lines_mean - Lines with no content mean
 * blank_lines_median - Lines with no content median
 * blank_lines_min - Lines with no content min
 * blank_lines_sd - Lines with no content standard deviation
 * blank_lines_sum - Lines with no content overall sum
 * cc_max - Cyclomatic complexity max
 * cc_mean - Cyclomatic complexity mean
 * cc_median - Cyclomatic complexity median
 * cc_min - Cyclomatic complexity min
 * cc_sd - Cyclomatic complexity standard deviation
 * cc_sum - Cyclomatic complexity overall sum
 * comments_max - comments max
 * comments_mean - comments mean
 * comments_median - comments median
 * comments_min - comments min
 * comments_sd - comments standard deviation
 * comments_sum - comments overall sum
 * halstaed_bugs_max - Halstaed bug probability max
 * halstaed_bugs_mean - Halstaed bug probability mean
 * halstaed_bugs_median - Halstaed bug probability median
 * halstaed_bugs_min - Halstaed bug probability min
 * halstaed_bugs_sd - Halstaed bug probability standard deviation
 * halstaed_bugs_sum - Halstaed bug probability overall sum
 * halstaed_calc_length_max - Halstaed calculated length max
 * halstaed_calc_length_mean - Halstaed calculated length mean
 * halstaed_calc_length_median - Halstaed calculated length median
 * halstaed_calc_length_min - Halstaed calculated length min
 * halstaed_calc_length_sd - Halstaed calculated length standard deviation
 * halstaed_calc_length_sum - Halstaed calculated length overall sum
 * halstaed_difficulty_max - Halstaed difficulty max
 * halstaed_difficulty_mean - Halstaed difficulty mean
 * halstaed_difficulty_median - Halstaed difficulty median
 * halstaed_difficulty_min - Halstaed difficulty min
 * halstaed_difficulty_sd - Halstaed difficulty standard deviation
 * halstaed_difficulty_sum - Halstaed difficulty overall sum
 * halstaed_dist_operands_max - Halstaed number of distinct operands max
 * halstaed_dist_operands_mean - Halstaed number of distinct operands mean
 * halstaed_dist_operands_median - Halstaed number of distinct operands median
 * halstaed_dist_operands_min - Halstaed number of distinct operands min
 * halstaed_dist_operands_sd - Halstaed number of distinct operands standard deviation
 * halstaed_dist_operands_sum - Halstaed number of distinct operands overall sum
 * halstaed_dist_operators_max - Halstaed number of distinct operators max
 * halstaed_dist_operators_mean - Halstaed number of distinct operators mean
 * halstaed_dist_operators_median - Halstaed number of distinct operators median
 * halstaed_dist_operators_min - Halstaed number of distinct operators min
 * halstaed_dist_operators_sd - Halstaed number of distinct operators standard deviation
 * halstaed_dist_operators_sum - Halstaed number of distinct operators overall sum
 * halstaed_effort_max - Halstaed effort max
 * halstaed_effort_mean - Halstaed effort mean
 * halstaed_effort_median - Halstaed effort median
 * halstaed_effort_min - Halstaed effort min
 * halstaed_effort_sd - Halstaed effort standard deviation
 * halstaed_effort_sum - Halstaed effort overall sum
 * halstaed_length_max - Halstaed length max
 * halstaed_length_mean - Halstaed length mean
 * halstaed_length_median - Halstaed length median
 * halstaed_length_min - Halstaed length min
 * halstaed_length_sd - Halstaed length standard deviation
 * halstaed_length_sum - Halstaed length overall sum
 * halstaed_time_max - Halstaed time max
 * halstaed_time_mean - Halstaed time mean
 * halstaed_time_median - Halstaed time median
 * halstaed_time_min - Halstaed time min
 * halstaed_time_sd - Halstaed time standard deviation
 * halstaed_time_sum - Halstaed time overall sum
 * halstaed_total_operands_max - Halstaed total number of operands max
 * halstaed_total_operands_mean - Halstaed total number of operands mean
 * halstaed_total_operands_median - Halstaed total number of operands median
 * halstaed_total_operands_min - Halstaed total number of operands min
 * halstaed_total_operands_sd - Halstaed total number of operands standard deviation
 * halstaed_total_operands_sum - Halstaed total number of operands overall sum
 * halstaed_total_operators_max - Halstaed total number of operators max
 * halstaed_total_operators_mean - Halstaed total number of operators mean
 * halstaed_total_operators_median - Halstaed total number of operators median
 * halstaed_total_operators_min - Halstaed total number of operators min
 * halstaed_total_operators_sd - Halstaed total number of operators standard deviation
 * halstaed_total_operators_sum - Halstaed total number of operators sum
 * halstaed_vocabulary_max - Halstaed vocabulary max
 * halstaed_vocabulary_mean - Halstaed vocabulary mean
 * halstaed_vocabulary_median - Halstaed vocabulary median
 * halstaed_vocabulary_min - Halstaed vocabulary min
 * halstaed_vocabulary_sd - Halstaed vocabulary standard deviation
 * halstaed_vocabulary_sum - Halstaed vocabulary overall sum
 * halstaed_volume_max - Halstaed volume max
 * halstaed_volume_mean - Halstaed volume mean
 * halstaed_volume_median - Halstaed volume median
 * halstaed_volume_min - Halstaed volume min
 * halstaed_volume_sd - Halstaed volume standard deviation 
 * halstaed_volume_sum - Halstaed volume overall sum
 * lloc_max - Logical Lines of Code max
 * lloc_mean - Logical Lines of Code mean
 * lloc_median - Logical Lines of Code median
 * lloc_min - Logical Lines of Code min
 * lloc_sd - Logical Lines of Code standard deviation
 * lloc_sum - Logical Lines of Code overall sum
 * loc_max - Lines of Code max
 * loc_mean - Lines of Code mean
 * loc_median - Lines of Code median
 * loc_min - Lines of Code min
 * loc_sd - Lines of Code standard deviation
 * loc_sum - Lines of Code overall sum
 * maint_index_max - Maintenance index max
 * maint_index_mean - Maintenance index mean
 * maint_index_median - Maintenance index median
 * maint_index_min - Maintenance index min
 * maint_index_sd - Maintenance index standard deviation
 * maint_index_sum - Maintenance index overall sum
 * multiline_strings_max - Multi-line strings max
 * multiline_strings_mean - Multi-line strings mean
 * multiline_strings_median - Multi-line strings median
 * multiline_strings_min - Multi-line strings min
 * multiline_strings_sd - Multi-line strings standard deviation
 * multiline_strings_sum - Multi-line strings overall sum
 * singleline_comments_max - Single-line comments max
 * singleline_comments_mean - Single-line comments mean
 * singleline_comments_median - Single-line comments median
 * singleline_comments_min - Single-line comments min
 * singleline_comments_sd - Single-line comments standard deviation
 * singleline_comments_sum - Single-line comments overall sum

Furthermore the following variables are defined for this module

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_radon | Blacklist filter for this tool | space-separated-list | ""
| SCA_RADON_ERROR_cyclomatic_max_gt | Threshold for maximum cyclomatic complexity before issuing an error | float-string | "30.0"
| SCA_RADON_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_RADON_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_RADON_WARN_cyclomatic_max_gt | Threshold for maximum cyclomatic complexity before issuing a warning | float-string | "15.0"

### Available configuration for rats

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_rats | Blacklist filter for this tool | space-separated-list | ""
| SCA_RATS_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_RATS_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for ropgadget

This module is somehow different. First of all it does not support suppression or fatal-error-handling.
Secondly it tries to get all code which is somehow exploitable by ROP (return oriented programming).
If the number of findings exceeds the configured threshold value a warning is issued.
The findings themselves are only created as "info" level findings. 
So if you actually want to see the details you can have a look into the raw-file or you have to 
configure SCA_WARNING_LEVEL to "info".

**NOTE**: a large value does not actually mean that your binary can be exploited, but a larger number actually raises the probality a lot that it could be done

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_ropgagdet | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_ROPGADGET_WARNING_THRESHOLD | Threshold value when to issue a warning | integer | "500"

### Available configuration for score

**NOTE**: This module does not support suppression or fatal error

This module does try to calculate a score (like pylint does) for all found finding by the configured tool.
It divides the score into 3 sections

 * security - covering all the issues that might be security relevant
 * functional - functional defects
 * style - only stylistic issues

You can configure a threshold value to issue a warning or an error when the calculated score is below.
This should help you identifing modules that are or bad quality in a certain way.

Do not expect any other output of this module than a warning or an error in build console (if you have the bitbake module enabled also there).

The default settings are taken from the individual tool setting files.

Following variables can be used

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_score | Blacklist filter for this tool | space-separated-list | ""
| SCA_SCORE_ERROR_PEN | Score penalty multiplier for an error | float | "7"
| SCA_SCORE_EXTRA_FUNCTIONAL | Extra finding IDs to put into functional classification | space-separated-list | ""
| SCA_SCORE_EXTRA_SECURITY | Extra finding IDs to put into security classification | space-separated-list | ""
| SCA_SCORE_EXTRA_STYLE | Extra finding IDs to put into style classification | space-separated-list | ""
| SCA_SCORE_FUNCTIONAL_ERROR | Threshold when to issue an error at functional score | float | "35"
| SCA_SCORE_FUNCTIONAL_PEN | Score penalty for a functional issue | float | "5"
| SCA_SCORE_FUNCTIONAL_WARN | Threshold when to issue a warning at functional score | float | "60"
| SCA_SCORE_INFO_PEN | Score penalty multiplier for an info | float | "1"
| SCA_SCORE_SECURITY_ERROR | Threshold when to issue an error at security score | float | "48"
| SCA_SCORE_SECURITY_PEN | Score penalty for a security issue | float | "100"
| SCA_SCORE_SECURITY_WARN | Threshold when to issue a warning at security score | float | "70"
| SCA_SCORE_SECURITY_WARN | Threshold when to issue a warning at security score | float | "70"
| SCA_SCORE_STYLE_ERROR | Threshold when to issue an error at style score | float | "15"
| SCA_SCORE_STYLE_PEN | Score penalty for a style issue | float | "1"
| SCA_SCORE_STYLE_WARN | Threshold when to issue a warning at style score | float | "40"
| SCA_SCORE_WARNING_PEN | Score penalty multiplier for a warning | float | "5"

### Available configuration for shellcheck

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_shellcheck | Blacklist filter for this tool | space-separated-list | ""
| SCA_SHELLCHECK_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | "":
| SCA_SHELLCHECK_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

### Available configuration for standard

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_standard | Blacklist filter for this tool | space-separated-list | ""
| SCA_STANDARD_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | "":
| SCA_STANDARD_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_STANDARD_FILE_FILTER | File extension to scan for | space-separated-list | ".js .jsx"

### Available configuration for stylelint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_stylelint | Blacklist filter for this tool | space-separated-list | ""
| SCA_STYLELINT_CONFIG | Config to use | 'stylelint-config-standard' or 'stylelint-config-recommended' | "stylelint-config-standard"
| SCA_STYLELINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | "":
| SCA_STYLELINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_STYLELINT_FILE_FILTER | Files to scan | space-separated-list | ".css .scss .html .htm"

### Available configuration for systemdlint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_systemdlint | Blacklist filter for this tool | space-separated-list | ""
| SCA_SYSTEMDLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | "":
| SCA_SYSTEMDLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_SYSTEMDLINT_SYSTEMD_VERSION | Specifies the version of systemd to be checked against. Leave empty to disable | version string | ""
| SCA_SYSTEMDLINT_FILES | File extensions to check on | space-separated-list | ".automount .conf .link .mount .network .path .service .slice .socket .swap .target .timer"
| SCA_SYSTEMDLINT_PATHS | Paths to search for systemd-files | space-separated-list | ${SCA_SOURCES_DIR}/${sysconfdir}/systemd ${SCA_SOURCES_DIR}/${libdir}/systemd ${SCA_SOURCES_DIR}/run/systemd

### Available configuration for textlint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_textlint | Blacklist filter for this tool | space-separated-list | ""
| SCA_TEXTLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_TEXTLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_TEXTLINT_ONLINE | Allow rules which requires online access to work | 0 or 1 | "1"
| SCA_TEXTLINT_RULES | List of rules to check on | space-separated-list | see sca-textlint.bbclass for details

### Available configuration for tlv

**NOTE**: This module does not support suppression or fatal error

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_tlv | Blacklist filter for this tool | space-separated-list | "linux-.*"
| SCA_TLV_MINLINES | Minimum number of lines before issue is reported | int | "8"
| SCA_TLV_MINTOKEN | Minimum number of token in block before issue is reported | int | "25"
| SCA_TLV_FILES | List of glob-expression for files to check | space-separated-list | "\$\{SCA\_SOURCES\_DIR\}/\* \$\{SCA\_SOURCES\_DIR\}/\*\*/\*" - for recipe, "\$\{SCA\_SOURCES\_DIR\}/\$\{sysconfdir\}/\* \$\{SCA\_SOURCES\_DIR\}/\$\{sysconfdir\}/\*\*/\*" - for image

### Available configuration for tscancode

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_tscancode | Blacklist filter for this tool | space-separated-list | "linux-*"
| SCA_TSCANCODE_CONFIG_FILES | Files to check for configuration symbols (header or KConfig) | space-separated-list | ".config config.h"
| SCA_TSCANCODE_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_TSCANCODE_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_TSCANCODE_FILE_FILTER | List of file-extensions to be checked | space-separated-list | ".cpp .cxx .cc .c++ .c .tpp .txx"
| SCA_TSCANCODE_INCLUDE_PATHS | Extra include paths **WARNING: this will heavily slow down thw check** | space-separated-list | ""
| SCA_TSCANCODE_SYMBOL_PREFIX | Prefix found symbols with | string | "ENABLE_"

### Available configuration for xmllint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_xmllint | Blacklist filter for this tool | space-separated-list | ""
| SCA_XMLLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_XMLLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_XMLLINT_FILE_FILTER | List of file-extensions to be checked | space-separated-list | ".xml"

### Available configuration for yamllint

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_yamllint | Blacklist filter for this tool | space-separated-list | ""
| SCA_YAMLLINT_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_YAMLLINT_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""
| SCA_YAMLLINT_FILE_FILTER | List of file-extensions to be checked | space-separated-list | ".yaml"

### Available configuration for zrd

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BLACKLIST_zrd | Blacklist filter for this tool | space-separated-list | ""
| SCA_ZRD_EXTRA_FATAL | Extra error-ids leading to build termination when found | space-separated-list | ""
| SCA_ZRD_EXTRA_SUPPRESS | Extra error-ids to be suppressed | space-separated-list | ""

## Suppression and fatal-error
Every tool has the possibility to suppress some of the findings.
Besides that some findings could be configured to terminate the build, e.g. when a nullptr-dereference is found in C-code.

For this purpose you can configure global suppression or fatal-error.
In the subdirectory __recipes-sca-rules__ you can find __rules__-files for each tool.

E.g. when you want to configure the behavior of pylint for when invoked on an image, you need to modify (or overload in your own layer) the files from __sca-image-pylint__.

Each of these rule-recipe consists of two files

 * suppress - which adds suppressions
 * fatal - which adds fatal errors

In these files every entry must be on a single line.
The format of the entry is defined by the analysis-tool itself.
(a wiki entry will follow soon)

Also you could use the __SCA_\<TOOLNAME\>_EXTRA_SUPPRESS__ and __SCA_\<TOOLNAME\>_EXTRA_FATAL__ variables in each recipe to control the behavior. 

## Results

Depending on how you configured the variable __SCA_EXPORT_DIR__ (default \${DEPLOY_DIR_IMAGE}/sca) you will find several files and folders.

- sca
  - cppcheck
    - checkstyle
    - raw
  - cpplint
    - checkstyle
    - raw
  - pylint
    - checkstyle
    - raw

a.s.o.

In each checkstyle-subfolder you will find a XML-document named __\${PN}_\${PV}.xml__ e.g. for recipe acl this would be acl_1.2.3.xml.
This document contains all findings in checkstyle-format.

In each raw-subfolder you will find the raw output of the tool, without any further processing done to it. The format depends on the tool.

## Source-File

If you enabled the bitbake-variable __SCA_EXPORT_FINDING_SRC__ (set it to "1") all source-files from the findings will be copied to structure like this

- sca
  - sources
    - \${PN}
      - \<items>

Also the corresponding path in each checkstyle-XML-document will be adjusted to point to the file copy.
With this help e.g. Jenkins will be capable of giving you inline snippets to the findings.

If you don't need this feature you should leave it disabled.

## BestOf mode
BestOf mode is an advanced filter for findings. In this mode only the findings are listed where more than one tool has reported a finding in source code.

You can call it the lazy programmers mode.
Main purpose of this module is to filter out the findings, which have been reported by one tool only. So the result of BestOf mode should give you a very strong hint that the finding reported is real.

You can either filter by a minimum number of tools that should have reported a finding (threshold), or by a percentage of tools that reported a finding (ratio).

The filtering is done on the basis of checked language (e.g. C, shell, python, a.s.o).
If there is only 1 tool available for the language the results will remain untouched/unfiltered.

This mode might be helpful for people who are drowning in false positives or are simply overwhelmed by the amount of findings.

__NOTE: the chance that this mode does also filter out important messages is extremely high. So use it with caution__

Following configuration exists

| var | purpose | type | default |
| ------------- |:-------------:| -----:| -----:
| SCA_BESTOF_MODE | Filter mode | threshold or ratio | "threshold"
| SCA_BESTOF_RATIO | Percentage of tools that reported a finding  | float 0.0-1.0 | "0.5"
| SCA_BESTOF_THRESHOLD_MIN | Minimum value of tools that reported a finding | number | "2"

## Further development

Feel free to create pull-requests or create an issue if you think there is something wrong or missing.
