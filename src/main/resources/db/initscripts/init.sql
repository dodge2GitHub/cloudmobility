SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;--Treats back slashes as escape characters
--disables validation of the function body string during sql-createfunction. Disabling validation avoids side effects of the validation process and avoids false positives due to --problems such as forward references
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

CREATE SCHEMA IF NOT EXISTS privatehospital;