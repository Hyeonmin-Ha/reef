#include "Clr2JavaImpl.h"

namespace Microsoft
{
	namespace Reef
	{
		namespace Driver
		{
			namespace Bridge
			{
				TaskMessageClr2Java::TaskMessageClr2Java(JNIEnv *env, jobject jtaskMessage)
				{
					pin_ptr<JavaVM*> pJavaVm = &_jvm;
					int gotVm = env -> GetJavaVM(pJavaVm);
					_jobjectTaskMessage = jtaskMessage;

					fprintf(stdout, "TaskMessageClr2Java env %p\n", env); fflush (stdout);
					fprintf(stdout, "TaskMessageClr2Java _jvm %p\n", _jvm); fflush (stdout);
					fprintf(stdout, "TaskMessageClr2Java _jobjectTaskMessage %p\n", _jobjectTaskMessage); fflush (stdout);
				}
			}
		}
	}
}