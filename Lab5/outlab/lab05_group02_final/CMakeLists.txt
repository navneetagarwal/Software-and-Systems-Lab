cmake_minimum_required(VERSION 2.6)
project(square_and_add)
set(CMAKE_BUILD_TYPE Release)
include_directories ("${PROJECT_SOURCE_DIR}/libsrc/include")
 
set(SOURCES libsrc/src/square.cc src/main.cc)
set(LDESTINATION libs)
add_executable(no_lib_exec ${SOURCES})
set_target_properties(no_lib_exec
    PROPERTIES OUTPUT_NAME sqnadd_no_lib
)
add_library(build_static_library STATIC ${SOURCES})
set_target_properties(build_static_library
	PROPERTIES OUTPUT_NAME static_library
)
link_directories( "${PROJECT_SOURCE_DIR}/build")
set ( PROJECT_LINK_LIBS1 static_library.a )

add_executable(static_lib_exec ${PROJECT_SOURCE_DIR}/src/main.cc)
set_target_properties(static_lib_exec
    PROPERTIES OUTPUT_NAME sqnadd_stat_lib

)
target_link_libraries(static_lib_exec ${PROJECT_LINK_LIBS1} )
 
 
add_library(build_dynamic_library SHARED ${SOURCES})
set_target_properties(build_dynamic_library
	PROPERTIES OUTPUT_NAME dynamic_library
)
set ( PROJECT_LINK_LIBS  dynamic_library.so )
add_executable(dynamic_lib_exec src/main.cc)
set_target_properties(dynamic_lib_exec
    PROPERTIES OUTPUT_NAME sqnadd_dyn_lib   
)
target_link_libraries(dynamic_lib_exec ${PROJECT_LINK_LIBS} )
SET(CMAKE_INSTALL_PREFIX ${PROJECT_SOURCE_DIR})
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY "${PROJECT_SOURCE_DIR}/libs/")
install(TARGETS build_static_library DESTINATION ${CMAKE_ARCHIVE_OUTPUT_DIRECTORY})
install(TARGETS build_dynamic_library DESTINATION ${CMAKE_ARCHIVE_OUTPUT_DIRECTORY})


