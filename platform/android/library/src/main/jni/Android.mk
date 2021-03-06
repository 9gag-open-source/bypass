LOCAL_PATH := $(call my-dir)

BYPASS_SRC := ../../../../../../src/

BYPASS_INCLUDE_PATH := ../../../../../../src/

include $(CLEAR_VARS)

LOCAL_MODULE	:= bypass
LOCAL_SRC_FILES := \
	bypass.cpp \
	$(BYPASS_SRC)parser.cpp \
	$(BYPASS_SRC)document.cpp \
	$(BYPASS_SRC)element.cpp \
	../../../../../../dep/libsoldout/markdown.c \
	../../../../../../dep/libsoldout/buffer.c \
	../../../../../../dep/libsoldout/array.c

LOCAL_C_INCLUDES := ../../../../../../dep/libsoldout ${LOCAL_PATH}/src /opt/local/include /usr/local/include $(BYPASS_INCLUDE_PATH)

NDK_APP_DST_DIR := ../../../build/ndk/$(TARGET_ARCH_ABI)

include $(BUILD_SHARED_LIBRARY)
